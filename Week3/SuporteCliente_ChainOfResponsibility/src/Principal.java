
// Exemplo de uso do padrão Chain of Responsibility
public class Principal {
	
    public static void main(String[] args) {
    
    	// Criação dos atendentes
        Atendente atendente1 = new AtendenteNivel1();
        Atendente atendente2 = new AtendenteNivel2();

        // Configuração da cadeia de responsabilidade
        atendente1.setProximo(atendente2);

        // Criação de uma solicitação
        Solicitacao solicitacao = new Solicitacao(2);

        // Solicitação é passada pela cadeia de atendentes
        atendente1.atenderSolicitacao(solicitacao);
    }

}
