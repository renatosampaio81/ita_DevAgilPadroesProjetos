
// Classe que possui uma referência para o estado atual e delega as chamadas aos métodos correspondentes

class ReprodutorMusica {
    private Estado estadoAtual;

    public ReprodutorMusica() {
        // Define o estado inicial como "Parado"
        estadoAtual = new EstadoParado();
    }

    public void setEstado(Estado estado) {
        estadoAtual = estado;
    }

    public void play() {
        estadoAtual.play();
        setEstado(new EstadoTocando());
    }

    public void pause() {
        estadoAtual.pause();
        setEstado(new EstadoPausado());
    }

    public void stop() {
        estadoAtual.stop();
        setEstado(new EstadoParado());
    }
}