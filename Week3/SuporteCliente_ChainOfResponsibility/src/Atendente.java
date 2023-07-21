
// Definição da interface para os tratadores de solicitação
public interface Atendente {
    void setProximo(Atendente proximo);
    void atenderSolicitacao(Solicitacao solicitacao);
}
