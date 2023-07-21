
public class EqualizadorDecorator extends MusicaDecorator {
    public EqualizadorDecorator(IMusica musicaDecorada) {
        super(musicaDecorada);
    }

    public void tocar() {
        super.tocar();
        aplicarEqualizacao();
    }

    private void aplicarEqualizacao() {
        System.out.println("Aplicando efeito de equalização na música");
    }
}

