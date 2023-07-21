
class EstadoPausado implements Estado {
    @Override
    public void play() {
        System.out.println("Retomando a reprodução da música...");
        // Altera o estado para "Tocando"
    }

    @Override
    public void pause() {
        System.out.println("A música já está pausada.");
    }

    @Override
    public void stop() {
        System.out.println("Parando a reprodução da música...");
        // Altera o estado para "Parado"
    }
}
