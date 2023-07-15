public class Pizza {

	public Pizza(String tipoPizza){
		this (tipoPizza,"grande", null, null, null);
	}
	
	public Pizza(String tipoPizza, String tamPizza) {
		this (tipoPizza, tamPizza, null, null, null);
	}

	public Pizza(String tipoPizza, String tamPizza, String massa) {
		this (tipoPizza, tamPizza, massa, null, null);
	}
	
	public Pizza(String tipoPizza, String tamPizza, String massa, String molho) {
		this (tipoPizza, tamPizza, massa, molho, null);
	}

	public Pizza(String tipoPizza, String tamPizza, String massa, String molho, String cobertura) {
		this.defineTipoProdutoPizza(tipoPizza);
		this.defineTamPizza(tamPizza);
		this.defineMassa(massa);
		this.defineMolho(molho);
		this.defineCobertura (cobertura);
	}
		
	public void defineTipoProdutoPizza(String tipoPizza) {
		this.tipoPizza = tipoPizza;
	}

	public void defineTamPizza (String tamPizza) {
		this. tamPizza = tamPizza;
	}
	
	public void defineMassa (String massa) {
		this.massa = massa;
	}
	
	public void defineMolho(String molho) {
		this. molho = molho;
	}
	
	public void defineCobertura (String cobertura) {
		this.cobertura = cobertura;
	}
	
	public String getTipoProdutoPizza(){
		return tipoPizza;
	}
	
	public String getTamPizza() {
		return tamPizza;
	}
	
	public String getMassa() {
		return massa;
	}
	
	public String getMolho () {
		return molho;
	}
	
	public String getCobertura() {
		return cobertura;
	}
	
	public void exibePizza() {
		System.out.println(
		"Pizza:" + getTipoProdutoPizza() +
		"\nTamanho: " + getTamPizza() +
		"\nMassa: " + getMassa() +
		"\nMolho: " + getMolho() +
		"\nCobertura: " + getCobertura());
	}
		
	// campos obrigatórios
	private String tipoPizza = "";
	private String tamPizza = "";
	// campos opcionais
	private String massa = "";
	private String molho = "";
	private String cobertura = "";
	
}