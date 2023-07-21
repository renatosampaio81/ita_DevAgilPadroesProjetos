
class EstadoTocando implements Estado {
    @Override
    public void play() {
        System.out.println("A música já está tocando.");
    }

    @Override
    public void pause() {
        System.out.println("Pausando a reprodução da música...");
        // Altera o estado para "Pausado"
    }

    @Override
    public void stop() {
        System.out.println("Parando a reprodução da música...");
        // Altera o estado para "Parado"
    }
}
