import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTarifaEstacionamento {

	@Test
	void tarifaFixaPorHora() {
		TarifaEstacionamento t = new TarifaEstacionamento(3, new CalculoHora(4)); // 3 horas , 4 valor da hora
		int valor = t.valor();
		assertEquals(12, valor);
	}
	
	@Test
	void tarifaComValorInicialDepoisFixaPorHora() {
		TarifaEstacionamento t = new TarifaEstacionamento(6, new CalculoHoraValorInicial(5, 3, 2)); // 6 horas , 5 valor pelas horas inicias , 3 horas iniciais e 2 valor por horas adicionais
		int valor = t.valor();
		assertEquals(11, valor);
	}
	
	@Test
	void tarifaComValorInicialDentroDoLimite() {
		TarifaEstacionamento t = new TarifaEstacionamento(2, new CalculoHoraValorInicial(5, 3, 2)); // 2 horas , 5 valor pelas horas inicias , 3 horas iniciais e 2 valor por horas adicionais
		int valor = t.valor();
		assertEquals(5, valor);
	}
	
	@Test
	void tarifaDiaria() {
		TarifaEstacionamento t = new TarifaEstacionamento(50, new CalculoDiaria(20)); // 50 horas , 20 reais a diária 
		int valor = t.valor();
		assertEquals(60, valor);
	}
	
	@Test
	void tarifaDiariaMenorQueUmDia() {
		TarifaEstacionamento t = new TarifaEstacionamento(10, new CalculoDiaria(20)); // 50 horas , 20 reais a diária 
		int valor = t.valor();
		assertEquals(20, valor);
	}

}
