
// Implementação concreta de um atendente específico
public class AtendenteNivel1 extends AtendenteBase {
    protected boolean podeAtender(Solicitacao solicitacao) {
        // Verifica se o atendente de nível 1 pode tratar a solicitação
        return solicitacao.getNivel() <= 1;
    }
}
