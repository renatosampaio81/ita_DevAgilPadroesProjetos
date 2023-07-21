
class EstadoParado implements Estado {
    @Override
    public void play() {
        System.out.println("Iniciando a reprodução da música...");
        // Altera o estado para "Tocando"
    }

    @Override
    public void pause() {
        System.out.println("Não é possível pausar, a música está parada.");
    }

    @Override
    public void stop() {
        System.out.println("A música já está parada.");
    }
}