public class Cliente{

	public static void main (String[] args) {
		// (1) cria Pizza Portuguesa
		Pizza portuguesa = new Pizza ("Portuguesa", "pequena", "fina", "não apimentado", "ovo+azeitona");
		// (2) usa produto
		portuguesa.exibePizza();
		
		System.out.println("\n---------\n");
		
		// (1) cria Pizza Italiana
		Pizza italiana = new Pizza("Italiana", "media", "grossa", "apimentado", "pepperoni+salame");
		// (2) usa produto
		italiana.exibePizza();
		
		System. out.println("\n---------\n");
		
		// (1) cria Pizza Marguerita
		Pizza marguerita = new Pizza ("Marguerita", "grande", "tomate", "fina", "tomate+orégano");
		// (2) usa produto
		marguerita.exibePizza();
	}

}
