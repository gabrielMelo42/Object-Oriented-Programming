import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Testes2
{
    public static void main(String[] args) 
    {
        MarcadorReuniao reuniao1 = new MarcadorReuniao();
        //exemplo2(reuniao2);
        //System.out.println();
        //exemplo1(reuniao1);
//reuniao1.mostrarSobreposicao();
        //reuniao2.mostrarSobreposicao();
//}

    

   // static void exemplo1(MarcadorReuniao reuniao){
        Collection<String> emails1 = new ArrayList<String>();
        LocalDate dataInicial1 = LocalDate.of(2019, 04, 20);
        LocalDate dataFinal1 = LocalDate.of(2019, 04, 23);

        emails1.add("ana@usp.br");
        emails1.add("paulo@usp.br");
        emails1.add("lucas@usp.br");
        //emails.add("julio");
        
        reuniao1.marcarReuniaoEntre(dataInicial1, dataFinal1, emails1);
        reuniao1.carregaTempoMinimo(30);

        reuniao1.indicaDisponibilidade("ana@usp.br", LocalDateTime.of(2019, 4, 20, 15, 00), LocalDateTime.of(2019, 4, 21, 18, 00));
        reuniao1.indicaDisponibilidade("paulo@usp.br", LocalDateTime.of(2019, 04, 21, 12, 00), LocalDateTime.of(2019, 04, 21, 20, 00));
        reuniao1.indicaDisponibilidade("ana@usp.br", LocalDateTime.of(2019, 04, 23, 12, 00), LocalDateTime.of(2019, 04, 23, 22, 00));
        reuniao1.indicaDisponibilidade("lucas@usp.br", LocalDateTime.of(2019, 04, 20, 14, 00), LocalDateTime.of(2019, 04, 23, 22, 00));
        reuniao1.indicaDisponibilidade("paulo@usp.br", LocalDateTime.of(2019, 04, 22, 16, 00), LocalDateTime.of(2019, 04, 23, 14, 00));
        //reuniao.indicaDisponibilidade("julio", LocalDateTime.of(2019, 04, 21, 06, 00), LocalDateTime.of(2019, 04, 22, 00, 00));
     reuniao1.mostraSobreposicao();
    
   // }


    //static void exemplo2(MarcadorReuniao reuniao){
      
        MarcadorReuniao reuniao2= new MarcadorReuniao();
        Collection<String> emails2 = new ArrayList<String>();    
        LocalDate dataInicial2 = LocalDate.of(2019, 05, 01);
        LocalDate dataFinal2 = LocalDate.of(2019, 05, 07);

        emails2.add("oliveira.8102@usp.br");
        emails2.add("matheus2060@usp.br");
        emails2.add("laiscarraro@usp.br");
        emails2.add("andre.casaes@usp.br");
        
        reuniao2.marcarReuniaoEntre(dataInicial2, dataFinal2, emails2);
        reuniao2.carregaTempoMinimo(45);

        reuniao2.indicaDisponibilidade("oliveira.8102@usp.br", LocalDateTime.of(2019, 05, 02, 19, 00), LocalDateTime.of(2019, 05, 02, 22, 00));
        reuniao2.indicaDisponibilidade("matheus2060@usp.br", LocalDateTime.of(2019, 05, 05, 12, 00), LocalDateTime.of(2019, 05, 05, 14, 00));
        reuniao2.indicaDisponibilidade("laiscarraro@usp.br", LocalDateTime.of(2019, 05, 05, 13, 00), LocalDateTime.of(2019, 05, 05, 14, 00));
        reuniao2.indicaDisponibilidade("andre.casaes@usp.br", LocalDateTime.of(2019, 05, 05, 13, 05), LocalDateTime.of(2019, 05, 05, 13, 50));
        reuniao2.indicaDisponibilidade("matheus2060@usp.br", LocalDateTime.of(2019, 5, 06, 13, 45), LocalDateTime.of(2019, 05, 07, 14, 00));
        reuniao2.indicaDisponibilidade("oliveira.8102@usp.br", LocalDateTime.of(2019, 5, 5, 10, 00), LocalDateTime.of(2019, 05, 05, 15, 30));
        //return reuniao;
        reuniao2.mostraSobreposicao();

        MarcadorReuniao reuniao3 = new MarcadorReuniao();
        Collection<String> emails3 = new ArrayList<String>();
        LocalDate dataInicial3 = LocalDate.of(2019, 8, 10);
        LocalDate dataFinal3 = LocalDate.of(2019, 11, 25);
        emails3.add("daniel-lima@usp.br");
        emails3.add("juliapassos@usp.br");
        emails3.add("oliveira.8102@usp.br");
        emails3.add("matheus2060@usp.br");

        reuniao3.marcarReuniaoEntre(dataInicial3, dataFinal3, emails3);
        reuniao3.indicaDisponibilidade("matheus2060@usp.br", LocalDateTime.of(2019, 8, 11, 15, 30), LocalDateTime.of(2019, 8, 27, 17, 45));
        reuniao3.indicaDisponibilidade("oliveira.8102@usp.br", LocalDateTime.of(2019, 8, 23, 8, 00), LocalDateTime.of(2019, 8, 26, 20, 15));
        reuniao3.indicaDisponibilidade("daniel-lima@usp.br", LocalDateTime.of(2019, 8, 25, 10, 40), LocalDateTime.of(2019, 8, 25, 19, 15));
        reuniao3.indicaDisponibilidade("juliapassos@usp.br", LocalDateTime.of(2019, 8, 25, 12, 10), LocalDateTime.of(2019, 8, 25, 15, 35));
        reuniao3.indicaDisponibilidade("oliveira.8102@usp.br", LocalDateTime.of(2019, 10, 12, 7, 30), LocalDateTime.of(2019, 10, 31, 9, 50));
        reuniao3.indicaDisponibilidade("matheus2060@usp.br", LocalDateTime.of(2019, 11, 22, 21, 00), LocalDateTime.of(2019, 11, 22, 23, 00));
        reuniao3.mostraSobreposicao();
    }
}




