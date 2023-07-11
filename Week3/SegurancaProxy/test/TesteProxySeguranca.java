import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteProxySeguranca {

	@Test
	void testeAutorizaAcesso() {
		Usuario guerra = new Usuario ("Guerra");
		guerra.autorizaAcesso("InterfaceNegocio", "executaTransacao");
		NegocioMock mock = new NegocioMock();
		InterfaceNegocio n = new SegurancaNegocio(mock, guerra);
		n.executaTransacao();
		assertTrue(mock.foiAcessado());
	}
	
	@Test
	void testeNaoAutorizaAcesso() {
		Usuario guerra = new Usuario ("Guerra");
		guerra.autorizaAcesso("InterfaceNegocio", "executaTransacao");
		NegocioMock mock = new NegocioMock();
		InterfaceNegocio n = new SegurancaNegocio(mock, guerra);
		try {
			n.cancelaTransacao();
			fail();
		} catch (Exception e) {
			assertFalse(mock.foiAcessado());
		}
		
	}

}
