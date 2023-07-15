
public class PizzaPortuguesaBuilder extends PizzaBuilder {

	@Override
	public void defineTipoPizza() {
		pizza.defineTipoPizza("Portuguesa");
	}
	
	@Override
	public void defineTamPizza(String tamPizza) {
		pizza.defineTamPizza(tamPizza);
	}
	
	@Override
	public void defineMassa() {
		pizza.defineMassa("fina");
	}

	@Override
	public void defineMolho() {
		pizza.defineMolho("não apimentado");
	}

	@Override
	public void defineCobertura() {
		pizza.defineCobertura("ovo+azeitona");
	}

}
