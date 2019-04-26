import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MarcadorReuniao 
{
    static LocalDate inicioReuniao;
    static LocalDate finalReuniao;
    static List<Participante> listaDePessoas = new ArrayList<Participante>();
    static List<LocalDateTime[]> interseccoes = new ArrayList<LocalDateTime[]>();

    public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes)
    {
        inicioReuniao = dataInicial;
        finalReuniao = dataFinal;
        
        for(String participante : listaDeParticipantes)
            listaDePessoas.add(new Participante(participante));
    }

    public void indicaDisponibilidade(String participante, LocalDateTime inicio, LocalDateTime fim) 
    {
        int i = 0;
        while(i < listaDePessoas.size())
        {
            if(listaDePessoas.get(i).email.equals(participante))
                break;
            i++;
        }
        listaDePessoas.get(i).inicioP.add(inicio);
        listaDePessoas.get(i).fimP.add(fim);
    }

    static boolean temInterseccao(LocalDateTime alpha1, LocalDateTime omega1, LocalDateTime alpha2, LocalDateTime omega2) 
    {
        if(alpha1.isBefore(alpha2) && omega1.isAfter(alpha2))
            return true;
        if(alpha1.isBefore(omega2) && omega1.isAfter(omega2))
            return true;
        return false;
    }

    static LocalDateTime[] retornaInterseccao(LocalDateTime alpha1, LocalDateTime omega1, LocalDateTime alpha2, LocalDateTime omega2) 
    {
        LocalDateTime[] resp = new LocalDateTime[2];

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

        return resp;
    }

    static void calculaInteseccoes() 
    {
        
    }

    public void mostraSobreposicao() 
    {
        
    }
}