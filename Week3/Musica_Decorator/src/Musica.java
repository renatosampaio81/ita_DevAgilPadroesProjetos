
public class Musica implements IMusica {
    private String nome;

    public Musica(String nome) {
        this.nome = nome;
    }

    public void tocar() {
        System.out.println("Tocando a música: " + nome);
    }
}

