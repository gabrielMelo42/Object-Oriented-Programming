import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
//import Participante;

public class MarcadorReuniao 
{
    static LocalDate _dataInicial;
    static LocalDate _dataFinal;
    static List<Participante> listaDePessoas = new ArrayList<Participante>();

    public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes)
    {
        _dataInicial = dataInicial;
        _dataFinal = dataFinal;

        for(String participante : listaDeParticipantes)
            listaDePessoas.add(new Participante(participante));
    }

    public void indicaDisponibilidade(String participante, LocalDateTime inicio, LocalDateTime fim) 
    {
        int i = 0;
        while(i < listaDePessoas.size())
        {
            if(listaDePessoas.get(i).nome.equals(participante))
                break;
            i++;
        }
        listaDePessoas.get(i).inicioP = inicio;
        listaDePessoas.get(i).fimP = fim;
    }

    public void mostraSobreposicao() 
    {

    }

    public static void main(String[] args) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        String[] dIni;
        String[] dFim;

        System.out.println("Insira o inicio do periodo desejado para a reuniao(dd/mm/aaaa): ");
        dIni = sc.next().split("/");
        _dataInicial = LocalDate.of(Integer.valueOf(dIni[2]), Integer.valueOf(dIni[1]), Integer.valueOf(dIni[0]));

        System.out.println("Insira o final do periodo desejado para a reuniao(dd/mm/aaaa): ");
        dFim = sc.next().split("/");
        _dataFinal = LocalDate.of(Integer.valueOf(dFim[2]), Integer.valueOf(dFim[1]), Integer.valueOf(dFim[0]));
        

        
    }
}