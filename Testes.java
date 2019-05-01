import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

class Testes
{
    public static void main(String[] args) 
    {
        MarcadorReuniao reuniao1 = new MarcadorReuniao();
        MarcadorReuniao reuniao2 = new MarcadorReuniao();
        MarcadorReuniao reuniao3 = new MarcadorReuniao();

        System.out.println("-=-=-=-=-=-=-=Reuniao 1-=-=-=-=-=-=-=");
        teste1(reuniao1);

        System.out.println("\n\n-=-=-=-=-=-=-=Reuniao 2-=-=-=-=-=-=-=");
        teste2(reuniao2);
        
        System.out.println("\n\n-=-=-=-=-=-=-=Reuniao 3-=-=-=-=-=-=-=");
        teste3(reuniao3);
    }

    static void teste1(MarcadorReuniao reuniao)
    {
        Collection<String> emails = new ArrayList<String>();

        LocalDate dataInicial = LocalDate.of(2019, 04, 20);
        LocalDate dataFinal = LocalDate.of(2019, 04, 23);

        emails.add("ana");
        emails.add("paulo");
        emails.add("lucas");
        // emails.add("julio");

        reuniao.marcarReuniaoEntre(dataInicial, dataFinal, emails);
        reuniao.carregaTempoMinimo(30);

        reuniao.indicaDisponibilidade("ana", LocalDateTime.of(2019, 04, 20, 15, 00),
                LocalDateTime.of(2019, 04, 21, 18, 00));
        reuniao.indicaDisponibilidade("paulo", LocalDateTime.of(2019, 04, 21, 12, 00),
                LocalDateTime.of(2019, 04, 21, 20, 00));
        reuniao.indicaDisponibilidade("ana", LocalDateTime.of(2019, 04, 23, 12, 00),
                LocalDateTime.of(2019, 04, 23, 22, 00));
        reuniao.indicaDisponibilidade("lucas", LocalDateTime.of(2019, 04, 20, 14, 00),
                LocalDateTime.of(2019, 04, 23, 22, 00));
        reuniao.indicaDisponibilidade("paulo", LocalDateTime.of(2019, 04, 22, 16, 00),
                LocalDateTime.of(2019, 04, 23, 14, 00));
        // reuniao.indicaDisponibilidade("julio", LocalDateTime.of(2019, 04, 21, 06,
        // 00), LocalDateTime.of(2019, 04, 22, 00, 00));

        reuniao.mostraSobreposicao();
    }

    static void teste2(MarcadorReuniao reuniao)
    {
        Collection<String> emails = new ArrayList<String>();

        LocalDate dataInicial = LocalDate.of(2019, 05, 01);
        LocalDate dataFinal = LocalDate.of(2019, 05, 07);

        emails.add("oliveira.8102@usp.br");
        emails.add("matheus2060@usp.br");
        emails.add("laiscarraro@usp.br");
        emails.add("andre.casaes@usp.br");

        reuniao.marcarReuniaoEntre(dataInicial, dataFinal, emails);
        reuniao.carregaTempoMinimo(45);

        reuniao.indicaDisponibilidade("oliveira.8102@usp.br", LocalDateTime.of(2019, 05, 02, 19, 00),
                LocalDateTime.of(2019, 05, 02, 22, 00));
        reuniao.indicaDisponibilidade("matheus2060@usp.br", LocalDateTime.of(2019, 05, 05, 12, 00),
                LocalDateTime.of(2019, 05, 05, 14, 00));
        reuniao.indicaDisponibilidade("laiscarraro@usp.br", LocalDateTime.of(2019, 05, 05, 13, 00),
                LocalDateTime.of(2019, 05, 05, 14, 00));
        reuniao.indicaDisponibilidade("andre.casaes@usp.br", LocalDateTime.of(2019, 05, 05, 13, 05),
                LocalDateTime.of(2019, 05, 05, 13, 50));
        reuniao.indicaDisponibilidade("matheus2060@usp.br", LocalDateTime.of(2019, 5, 06, 13, 45),
                LocalDateTime.of(2019, 05, 07, 14, 00));
        reuniao.indicaDisponibilidade("oliveira.8102@usp.br", LocalDateTime.of(2019, 5, 5, 10, 00),
                LocalDateTime.of(2019, 05, 05, 15, 30));
        
                
        reuniao.mostraSobreposicao();
    }

    static void teste3(MarcadorReuniao reuniao)
    {
        Collection<String> email = new ArrayList<String>();
        LocalDate dataInicial = LocalDate.of(2019, 8, 10);
        LocalDate dataFinal = LocalDate.of(2019, 11, 25);
        email.add("daniel-lima@usp.br");
        email.add("juliapassos@usp.br");
        email.add("oliveira.8102@usp.br");
        email.add("matheus2060@usp.br");

        reuniao.marcarReuniaoEntre(dataInicial, dataFinal, email);
        reuniao.indicaDisponibilidade("matheus2060@usp.br", LocalDateTime.of(2019, 8, 11, 15, 30),
                LocalDateTime.of(2019, 8, 27, 17, 45));
        reuniao.indicaDisponibilidade("oliveira.8102@usp.br", LocalDateTime.of(2019, 8, 23, 8, 00),
                LocalDateTime.of(2019, 8, 26, 20, 15));
        reuniao.indicaDisponibilidade("daniel-lima@usp.br", LocalDateTime.of(2019, 8, 25, 10, 40),
                LocalDateTime.of(2019, 8, 25, 19, 15));
        reuniao.indicaDisponibilidade("juliapassos@usp.br", LocalDateTime.of(2019, 8, 25, 12, 10),
                LocalDateTime.of(2019, 8, 25, 15, 35));
        reuniao.indicaDisponibilidade("oliveira.8102@usp.br", LocalDateTime.of(2019, 10, 12, 7, 30),
                LocalDateTime.of(2019, 10, 31, 9, 50));
        reuniao.indicaDisponibilidade("matheus2060@usp.br", LocalDateTime.of(2019, 11, 22, 21, 00),
                LocalDateTime.of(2019, 11, 22, 23, 00));
        reuniao.mostraSobreposicao();
    }
}