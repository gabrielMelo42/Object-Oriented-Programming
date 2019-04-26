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

        //inserindo informações dos participantes
        String auxEmail = "";
        LocalDateTime auxInicio;
        LocalDateTime auxFim;
        System.out.println("\nInsira as disponibilidades dos partipantes: ");
        while(true)
        {
            System.out.print("Email: ");
            auxEmail = sc.nextLine();

            System.out.print("Inicio do periodo disponivel(dd/mm/aaaa hh:mm): ");
            dIni = sc.nextLine().split("/| |:");
            auxInicio = LocalDateTime.of(Integer.valueOf(dIni[2]), Integer.valueOf(dIni[1]), Integer.valueOf(dIni[0]), Integer.valueOf(dIni[3]), Integer.valueOf(dIni[4]));

            System.out.print("Final do periodo disponivel(dd/mm/aaaa hh:mm): ");
            dFim = sc.nextLine().split("/| |:");
            auxFim = LocalDateTime.of(Integer.valueOf(dFim[2]), Integer.valueOf(dFim[1]), Integer.valueOf(dFim[0]), Integer.valueOf(dFim[3]), Integer.valueOf(dFim[4]));
            
            //colocar num metodo esses testes todos, esse metodo está em marcadorreuniao
            if(auxInicio.isAfter(auxFim)){
                System.out.println("A data inicial deve ser apos a data inicial, por favor :)");
                break;
            }

            reuniao.indicaDisponibilidade(auxEmail, auxInicio, auxFim);
            System.out.print("Deseja inserir mais uma disponibilidade(s/n):");
            if (sc.nextLine().charAt(0) == 'n')
                break;
            else
                System.out.println();
        }

    }
}