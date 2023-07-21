public class Circle extends Shape {
	
    public Circle(Color color) {
        super(color);
    }

    public void draw() {
        System.out.println("Desenhando um círculo " + color.getColor());
    }
}