
public class TextEditorAdapter implements TextEditor {
	
    private Printer printer;

    public TextEditorAdapter(Printer printer) {
        this.printer = printer;
    }

    public void write(String text) {
        printer.print(text);
    }

}
