import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestQuebradorPalavras {

	@Test
	void quebradorPalavras() {
		String frase = "o rato roeu a roupa do rei";
		QuebradorPalavras quebrador = new QuebradorPalavras();
		String[] palavras = quebrador.quebrar(frase);
		assertEquals(7,palavras.length);
	}
	
	@Test
	void contadorSimples() {
		String frase = "o rato roeu a roupa do rei";
		QuebradorPalavras quebrador = new QuebradorPalavras();
		quebrador.adicionaContador("SIMPLES",new ContadorSimples());
		quebrador.quebrar(frase);
		assertEquals(7,quebrador.getContagem("SIMPLES"));
	}
	
	@Test
	void contadorMaiuscula() {
		String frase = "o Rato roeu a roupa do Rei";
		QuebradorPalavras quebrador = new QuebradorPalavras();
		quebrador.adicionaContador("MAIUSCULA",new ContadorMaiuscula());
		quebrador.quebrar(frase);
		assertEquals(2,quebrador.getContagem("MAIUSCULA"));
	}
	
	@Test
	void contadorLetrasPares() {
		String frase = "o Rato roeu a roupa do Rei";
		QuebradorPalavras quebrador = new QuebradorPalavras();
		quebrador.adicionaContador("PARES",new ContadorPares());
		quebrador.quebrar(frase);
		assertEquals(3,quebrador.getContagem("PARES"));
	}
	
	@Test
	void contadorIntegrado() {
		String frase = "o Rato roeu a roupa do Rei";
		QuebradorPalavras quebrador = new QuebradorPalavras();
		quebrador.adicionaContador("PARES",new ContadorPares());
		quebrador.adicionaContador("MAIUSCULA",new ContadorMaiuscula());
		quebrador.adicionaContador("SIMPLES",new ContadorSimples());
		quebrador.quebrar(frase);
		assertEquals(3,quebrador.getContagem("PARES"));
		assertEquals(2,quebrador.getContagem("MAIUSCULA"));
		assertEquals(7,quebrador.getContagem("SIMPLES"));
	}

}
