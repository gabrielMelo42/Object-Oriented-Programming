import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MarcadorReuniao 
{
    static LocalDate _dataInicial;
    static LocalDate _dataFinal;
    static List<Participante> _listaDePessoas = new ArrayList<Participante>();

    public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes)
    {
        _dataInicial = dataInicial;
        _dataFinal = dataFinal;

        for(String participante : listaDeParticipantes)
            _listaDePessoas.add(new Participante(participante));
    }

    public void indicaDisponibilidade(String participante, LocalDateTime inicio, LocalDateTime fim) 
    {
        int i = 0;
        while(i < _listaDePessoas.size())
        {
            if(_listaDePessoas.get(i).email.equals(participante))
                break;
            i++;
        }
        _listaDePessoas.get(i).inicioP.add(inicio);
        _listaDePessoas.get(i).fimP.add(fim);
    }

    public void mostraSobreposicao() 
    {

    }
}