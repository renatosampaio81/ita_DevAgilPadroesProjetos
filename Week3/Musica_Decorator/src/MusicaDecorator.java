
public abstract class MusicaDecorator implements IMusica {
    protected IMusica musicaDecorada;

    public MusicaDecorator(IMusica musicaDecorada) {
        this.musicaDecorada = musicaDecorada;
    }

    public void tocar() {
        musicaDecorada.tocar();
    }
}

