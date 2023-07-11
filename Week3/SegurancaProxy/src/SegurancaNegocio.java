
public class SegurancaNegocio implements InterfaceNegocio { //essa classe é o proxy

	private InterfaceNegocio encapsulado;
	Usuario u;

	public SegurancaNegocio(InterfaceNegocio encapsulado, Usuario u) {
		this.encapsulado = encapsulado;
		this.u = u;
	}

	public void executaTransacao() {
		if(u.verificaPermissao("InterfaceNegocio", "executaTransacao")) {
			encapsulado.executaTransacao();
		} else {
			throw new RuntimeException();
		}
	}

	public void cancelaTransacao() {
		if(u.verificaPermissao("InterfaceNegocio", "cancelaTransacao")) {
			encapsulado.cancelaTransacao();
		} else {
			throw new RuntimeException();
		}
	}
	
	
}
