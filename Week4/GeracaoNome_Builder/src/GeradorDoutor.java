
public class GeradorDoutor extends GeradorNome {

	@Override
	protected String getTratamento() { //hook method
		return "Doutor ";
	}

}
