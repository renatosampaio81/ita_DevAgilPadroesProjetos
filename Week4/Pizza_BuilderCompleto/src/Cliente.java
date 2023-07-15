public class Cliente {
	
	public static void main(String[] args) {
		
		// (1) cria Diretor --> GarcomDiretor
		GarcomDiretor garcom = new GarcomDiretor();
	
		// (2) cria Builder para pizza Portuguêsa
		PizzaBuilder pizzaPortuguesaBuilder = new PizzaPortuguesaBuilder();
		
		// (3) injeta Builder no GarcomDiretor
		ProdutoPizza pp = garcom.definePizzaBuilder( pizzaPortuguesaBuilder )
				.montaPizza("pequena"); // (4) monta e entrega produto:	
		
		// pizza Portuguesa pequena
		pp.exibePizza(); // (5) usa produto pizza
		System.out.println("\n-- --- ----\n");
		
		// (2) cria Builder para pizza Italiana
		PizzaBuilder pizzaItalianaBuilder = new PizzaItalianaBuilder();
		
		// (3) injeta Builder no GarcomDiretor
		garcom.definePizzaBuilder( pizzaItalianaBuilder );
		pp = garcom.montaPizza("media"); // (4) monta e entrega produto:
		
		// pizza Italiana média
		pp.exibePizza(); // (5) usa produto pizza
		System.out.println("\n-- --- ----\n");
		
		// (2) cria Builder para pizza Marguerita
		PizzaBuilder pizzaMargueritaBuilder = new PizzaMargueritaBuilder();
		
		// (3) injeta Builder no GarcomDiretor
		garcom.definePizzaBuilder( pizzaMargueritaBuilder )
		.montaPizza("grande") // (4) monta e entrega produto:
		
		// pizza Marguerita grande
		.exibePizza();// (5) usa produto pizza

	}
	
}