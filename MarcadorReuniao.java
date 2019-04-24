package EP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import Participante;

public class MarcadorReuniao 
{
    LocalDate dataInicial;
    LocalDate dataFinal;
    Collection<Participante> listaDePessoas = new ArrayList();

    public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes)
    {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;

        for(String participante : listaDeParticipantes)
            this.listaDePessoas.add(new Participante(participante));
    }

    public void indicaDisponibilidade(String participante, LocalDateTime inicio, LocalDateTime fim) 
    {
        int i = 0;
        while(i < this.listaDePessoas.size())
        {
            if(this.listaDePessoas.get(i).nome.equals(participante))
                break;
            i++;
        }
        this.listaDePessoas.get(i).inicioP = inicio;
        this.listaDePessoas.get(i).fimP = fim;
    }

    public void mostraSobreposicao() 
    {

    }

    public static void main(String[] args) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
    }
}