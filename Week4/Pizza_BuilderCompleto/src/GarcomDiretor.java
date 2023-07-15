
public class GarcomDiretor {
	
	private PizzaBuilder pizzaBuilder;
	
	public GarcomDiretor definePizzaBuilder(PizzaBuilder pizzaBuilder) {
		// (2.1) associa PizzaBuilder
		this.pizzaBuilder = pizzaBuilder;
		// (2.2) devolve objeto GarcomDiretor
		return this;
	}
	
	public ProdutoPizza montaPizza(String tamPizza) {
		// (4.1) cria novo Produto, agora com tamanho definido!
		pizzaBuilder.criaNovoProdutoPizza();
		pizzaBuilder.defineTipoPizza();
		pizzaBuilder.defineTamPizza(tamPizza);
		pizzaBuilder.defineMassa();
		pizzaBuilder.defineMolho();
		pizzaBuilder.defineCobertura();
		// (4.2) entrega produto
		return pizzaBuilder.getPizza();
	}
	
}
