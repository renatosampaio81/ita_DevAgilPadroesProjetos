
public class ContadorSimples implements ContadorPalavras {
	
	private int qtd;

	@Override
	public void contar(String palavra) {
		qtd++;
	}

	@Override
	public Integer contagem() {
		return qtd;
	}

}
