
// Implementação concreta de outro atendente específico
public class AtendenteNivel2 extends AtendenteBase {
    protected boolean podeAtender(Solicitacao solicitacao) {
        // Verifica se o atendente de nível 2 pode tratar a solicitação
        return solicitacao.getNivel() <= 2;
    }
}
