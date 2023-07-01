
public class DescontoPercentual implements Desconto {
	
	private double percentual;

	public DescontoPercentual(int percentual) {
		super();
		this.percentual = percentual;
	}

	@Override
	public double darDesconto(double valorOriginal) {
		return (100.0 - percentual) / 100 * valorOriginal;
	}

}
