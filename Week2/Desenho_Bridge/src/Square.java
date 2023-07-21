public class Square extends Shape {
	
    public Square(Color color) {
        super(color);
    }

    public void draw() {
        System.out.println("Desenhando um quadrado " + color.getColor());
    }
}