
public class Principal {

	public static void main(String[] args) {
		ReprodutorMusica reprodutor = new ReprodutorMusica();

		reprodutor.play(); // Inicia a reprodução da música
	    reprodutor.pause(); // Pausa a reprodução da música
	    reprodutor.play(); // Retoma a reprodução da música
	    reprodutor.stop(); // Para a reprodução da música
	}
	
}
