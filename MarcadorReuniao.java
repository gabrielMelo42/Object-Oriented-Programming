import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class MarcadorReuniao 
{
    static LocalDate inicioReuniao;
    static LocalDate finalReuniao;
    static int tempoMinimo;
    static ArrayList<Participante> listaDePessoas = new ArrayList<Participante>();
    static ArrayList<LocalDateTime[]> interseccoes = new ArrayList<LocalDateTime[]>();

    void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes)
    {
        inicioReuniao = dataInicial;
        finalReuniao = dataFinal;
        
        for(String participante : listaDeParticipantes)
            listaDePessoas.add(new Participante(participante));
        
    }

    void indicaDisponibilidade(String participante, LocalDateTime inicio, LocalDateTime fim) 
    {
        int i = 0;
        while(i < listaDePessoas.size())
        {
            if(listaDePessoas.get(i).email.equals(participante))
                break;
            i++;
        }

        if(temInterseccao(inicioReuniao.atStartOfDay(), finalReuniao.atTime(23, 59), inicio, fim)) 
        {
            LocalDateTime[] intersec = retornaInterseccao(inicio, fim, inicioReuniao.atStartOfDay(), finalReuniao.atTime(23, 59));

            try
            {
                listaDePessoas.get(i).inicioP.add(intersec[0]);
                listaDePessoas.get(i).fimP.add(intersec[1]);
            }
            catch(Exception e)
            {
                System.out.println("A pessoa em questão não foi encontrada, insira um nome válido/existente.");
            }
                
        }
    }

    public void carregaTempoMinimo(int tempo)
    {
        tempoMinimo = tempo;
    }

    static boolean temInterseccao(LocalDateTime alpha1, LocalDateTime omega1, LocalDateTime alpha2, LocalDateTime omega2) 
    {
        if (alpha2.until(omega2, ChronoUnit.MINUTES) > alpha1.until(omega1, ChronoUnit.MINUTES)) {
            LocalDateTime[] aux = { alpha2, omega2 };
            alpha2 = alpha1;
            omega2 = omega1;
            alpha1 = aux[0];
            omega1 = aux[1];
        }

        if(alpha1.isBefore(alpha2) && omega1.isAfter(alpha2))
            return true;
        if(alpha1.isBefore(omega2) && omega1.isAfter(omega2))
            return true;
        return false;
    }

    static LocalDateTime[] retornaInterseccao(LocalDateTime alpha1, LocalDateTime omega1, LocalDateTime alpha2, LocalDateTime omega2) 
    {
        LocalDateTime[] resp = new LocalDateTime[2];

        if (alpha2.until(omega2, ChronoUnit.MINUTES) > alpha1.until(omega1, ChronoUnit.MINUTES)) {
            LocalDateTime[] aux = { alpha2, omega2 };
            alpha2 = alpha1;
            omega2 = omega1;
            alpha1 = aux[0];
            omega1 = aux[1];
        }

        if(alpha1.isBefore(alpha2) && omega1.isAfter(alpha2))
        {
            resp[0] = alpha2;
            if(alpha1.isBefore(omega2) && omega1.isAfter(omega2))
                resp[1] = omega2;
            else
                resp[1] = omega1;
        }
        else
        {
            resp[1] = omega2;
            if(alpha1.isBefore(alpha2) && omega1.isAfter(alpha2))
                resp[0] = alpha2;
            else
                resp[0] = alpha1; 
        }

        if(resp[0].isAfter(resp[1]))
        {
            LocalDateTime aux = resp[1];
            resp[1] = resp[0];
            resp[0] = aux;
        }

        return resp;
    }

    static boolean ehInterseccaoRepetida(LocalDateTime[] inter)
    {
        for(int i = 0; i < interseccoes.size(); i++)
            if(inter[0].isEqual(interseccoes.get(i)[0]) && inter[1].isEqual(interseccoes.get(i)[1]) )
                return true;
        return false;
    }

    static void calculaInteseccoes(int count, LocalDateTime[] auxPeriodo) 
    {
        for(int i = 0; i < listaDePessoas.get(count).inicioP.size(); i++)
        {
            if(count == 0)
            {
                auxPeriodo[0] = listaDePessoas.get(0).inicioP.get(i);
                auxPeriodo[1] = listaDePessoas.get(0).fimP.get(i);
            }
            
            for(int j = 0; j < listaDePessoas.get(count+1).inicioP.size(); j++)
            {
                LocalDateTime[] compara = {listaDePessoas.get(count+1).inicioP.get(j), listaDePessoas.get(count+1).fimP.get(j)};
                
                if(temInterseccao(auxPeriodo[0], auxPeriodo[1], compara[0], compara[1]))
                {
                    LocalDateTime[] intersec = retornaInterseccao(auxPeriodo[0], auxPeriodo[1], compara[0], compara[1]);

                    if(count < listaDePessoas.size()-2)
                    {
                        calculaInteseccoes(count + 1, intersec);
                    }
                    else
                    {
                        if(intersec[0].until(intersec[1], ChronoUnit.MINUTES) >= tempoMinimo)
                        {
                            if(!ehInterseccaoRepetida(intersec))
                            {
                                interseccoes.add(intersec);    
                            }
                        }
                    }
                }
            }
        }
    }

    void mostraSobreposicao() 
    {
        calculaInteseccoes(0, new LocalDateTime[2]);

        for(int i = 0; i < interseccoes.size(); i++)
        {
            System.out.println( (i+1) + "º janela de oportunidade: ");
            System.out.println( "Horario de inicio: " + interseccoes.get(i)[0]);
            System.out.println( "Horario de fim: " + interseccoes.get(i)[1] + "\n");
        }

        removeAll();
    }

    public void removeAll() {
        listaDePessoas.clear();
        interseccoes.clear();
    }
}