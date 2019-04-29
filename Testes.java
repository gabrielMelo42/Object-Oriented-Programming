import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

class Testes
{
    public static void main(String[] args) 
    {
        MarcadorReuniao reuniao = new MarcadorReuniao();
        Collection<String> emails = new ArrayList<String>();

        LocalDate dataInicial = LocalDate.of(2019, 04, 20);
        LocalDate dataFinal = LocalDate.of(2019, 04, 23);

        emails.add("ana");
        emails.add("paulo");
        emails.add("lucas");
        //emails.add("julio");
        
        reuniao.marcarReuniaoEntre(dataInicial, dataFinal, emails);
        reuniao.carregaTempoMinimo(30);

        reuniao.indicaDisponibilidade("ana", LocalDateTime.of(2019, 04, 20, 15, 00), LocalDateTime.of(2019, 04, 21, 18, 00));
        reuniao.indicaDisponibilidade("paulo", LocalDateTime.of(2019, 04, 21, 12, 00), LocalDateTime.of(2019, 04, 21, 20, 00));
        reuniao.indicaDisponibilidade("ana", LocalDateTime.of(2019, 04, 23, 12, 00), LocalDateTime.of(2019, 04, 23, 22, 00));
        reuniao.indicaDisponibilidade("lucas", LocalDateTime.of(2019, 04, 20, 14, 00), LocalDateTime.of(2019, 04, 23, 22, 00));
        reuniao.indicaDisponibilidade("paulo", LocalDateTime.of(2019, 04, 22, 16, 00), LocalDateTime.of(2019, 04, 23, 14, 00));
        //reuniao.indicaDisponibilidade("julio", LocalDateTime.of(2019, 04, 21, 06, 00), LocalDateTime.of(2019, 04, 22, 00, 00));
 
        reuniao.mostraSobreposicao();
    }
}