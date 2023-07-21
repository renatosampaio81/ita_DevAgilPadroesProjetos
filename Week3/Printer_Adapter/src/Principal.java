
public class Principal {

	public static void main(String[] args) {
		
		Printer printer = new Printer();
        TextEditor textEditor = new TextEditorAdapter(printer);

        textEditor.write("Olá, mundo!");

	}

}
