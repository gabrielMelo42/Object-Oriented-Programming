import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

class App 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        MarcadorReuniao reuniao = new MarcadorReuniao();
        Collection<String> emails = new ArrayList<String>();
        String[] dIni;
        String[] dFim;
        LocalDate auxDataInicial;
        LocalDate auxDataFinal;

        //definido datas para a reunião
        System.out.println("Insira o inicio do periodo desejado para a reuniao(dd/mm/aaaa): ");
        dIni = sc.next().split("/");
        auxDataInicial = LocalDate.of(Integer.valueOf(dIni[2]), Integer.valueOf(dIni[1]), Integer.valueOf(dIni[0]));

        System.out.println("Insira o final do periodo desejado para a reuniao(dd/mm/aaaa): ");
        dFim = sc.next().split("/");
        auxDataFinal = LocalDate.of(Integer.valueOf(dFim[2]), Integer.valueOf(dFim[1]), Integer.valueOf(dFim[0]));

        //inserindo os participantes
        System.out.println("Digite as pessoas requeridas(insira 'break' para parar): ");
        String insercao = "";
        while (true) {
            insercao = sc.nextLine();
            if (insercao.equals("break"))
                break;
            else
                emails.add(insercao);
        }
        reuniao.marcarReuniaoEntre(auxDataInicial, auxDataFinal, emails);

        
    }
}