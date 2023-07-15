
public class GeradorNome {
	
	private Tratamento tratamento = new NullTratamento(); //Strategy para Tratamento e NullObject pro NullTratamento

	public String gerarNome(String nomeBase) {
		return tratamento.tratar() + getTratamento() + nomeBase;
	}
	
	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}

	protected String getTratamento() {
		return "";
	}
	
	public Tratamento getTratamentoStrategy() {
		return tratamento;
	}

}
