public class EP{
	public static void main(String [] args){
		System.out.println("Hello World");

	}

	public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes);
	public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim);
	public void mostraSobreposicao();
}