public class Testes4{
	public static void exemplo2(){

        MarcadorReuniao reuniao= new MarcadorReuniao();
        Collection<String> emails = new ArrayList<String>();    
        LocalDate dataInicial = LocalDate.of(2019, 05, 01);
        LocalDate dataFinal = LocalDate.of(2019, 05, 07);
      //  dataInicial = LocalDate.of(2019, 05, 01);
        //dataFinal = LocalDate.of(2019, 05, 07);
        
        emails.add("oliveira.8102@usp.br");
        emails.add("matheus2060@usp.br");
        emails.add("laiscarraro@usp.br");
        emails.add("andre.casaes@usp.br");
        
        reuniao.marcarReuniaoEntre(dataInicial, dataFinal, emails);
        reuniao.carregaTempoMinimo(45);

        reuniao.indicaDisponibilidade("oliveira.8102@usp.br", LocalDateTime.of(2019, 05, 02, 19, 00), LocalDateTime.of(2019, 05, 02, 22, 00));
        reuniao.indicaDisponibilidade("matheus2060@usp.br", LocalDateTime.of(2019, 05, 05, 12, 00), LocalDateTime.of(2019, 05, 05, 14, 00));
        reuniao.indicaDisponibilidade("laiscarraro@usp.br", LocalDateTime.of(2019, 05, 05, 13, 00), LocalDateTime.of(2019, 05, 05, 14, 00));
        reuniao.indicaDisponibilidade("andre.casaes@usp.br", LocalDateTime.of(2019, 05, 05, 13, 05), LocalDateTime.of(2019, 05, 05, 13, 50));
        reuniao.indicaDisponibilidade("matheus2060@usp.br", LocalDateTime.of(2019, 5, 06, 13, 45), LocalDateTime.of(2019, 05, 07, 14, 00));
        reuniao.indicaDisponibilidade("oliveira.8102@usp.br", LocalDateTime.of(2019, 5, 5, 10, 00), LocalDateTime.of(2019, 05, 05, 15, 30));
        //return reuniao;
    //    System.out.println("abc");
        reuniao.mostraSobreposicao();
    }
}

