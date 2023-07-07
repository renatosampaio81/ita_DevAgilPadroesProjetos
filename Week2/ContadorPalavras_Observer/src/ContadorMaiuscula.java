
public class ContadorMaiuscula implements ContadorPalavras {
	
	private int qtd;

	@Override
	public void contar(String palavra) {
		if(Character.isUpperCase(palavra.charAt(0)))
			qtd++;
	}

	@Override
	public Integer contagem() {
		return qtd;
	}

}
