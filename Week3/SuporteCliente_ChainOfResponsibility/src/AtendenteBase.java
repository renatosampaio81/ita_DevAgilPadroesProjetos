
// Implementação básica de um atendente
public abstract class AtendenteBase implements Atendente {
    private Atendente proximo;

    public void setProximo(Atendente proximo) {
        this.proximo = proximo;
    }

    public void atenderSolicitacao(Solicitacao solicitacao) {
        if (podeAtender(solicitacao)) {
            // Trata a solicitação
            System.out.println("Solicitação tratada por " + this.getClass().getSimpleName());
        } else if (proximo != null) {
            // Passa a solicitação adiante
            proximo.atenderSolicitacao(solicitacao);
        } else {
            // Nenhum atendente pode tratar a solicitação
            System.out.println("Nenhum atendente pode tratar a solicitação");
        }
    }

    protected abstract boolean podeAtender(Solicitacao solicitacao);
}