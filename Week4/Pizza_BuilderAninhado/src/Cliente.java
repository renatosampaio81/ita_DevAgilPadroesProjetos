
public class Cliente {
	
	public static void main(String[] args) {
	
		// (1) cria Pizza Portuguesa
		new Pizza
			.PizzaBuilder("Portuguesa", "pequena")
			.defineMassa("fina")
			.defineMolho("não apimentado")
			.defineCobertura("ovo+azeitona")
			.montaPizza( )// (2) monta e entrega produto pizza portuguesa
			.exibePizza();// (3) usa produto
			
		System.out.println("\n-- --- ----\n");
	
		
		// (1) cria Pizza Italiana
		new Pizza
			.PizzaBuilder("Italiana", "média")
			.defineMassa("grossa")
			.defineMolho("apimentado")
			.defineCobertura("pepperoni+salame")
			.montaPizza( )// (2) monta e entrega produto pizza italiana
			.exibePizza();// (3) usa produto
		
		System.out.println("\n-- --- ----\n");
	
		
		// (1) cria Pizza Marguerita
			new Pizza
				.PizzaBuilder("Marguerita", "grande")
				.defineMassa("fina")
				.defineMolho("tomate")
				.defineCobertura("tomate+orégano")
				.montaPizza( )// (2) monta e entrega produto pizza marguerita
				.exibePizza();// (3) usa produto
		
	}
	
}