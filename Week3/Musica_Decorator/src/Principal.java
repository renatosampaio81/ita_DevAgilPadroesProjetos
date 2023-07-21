
public class Principal {

	public static void main(String[] args) {
		
		IMusica musica = new Musica("Nome da Música");
		musica = new EqualizadorDecorator(musica);

		musica.tocar();

	}

}
