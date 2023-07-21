
public class Principal {
	
	public static void main(String[] args) {
	Color red = new Red();
	Shape circle = new Circle(red);
	circle.draw();

	Color green = new Green();
	Shape square = new Square(green);
	square.draw();
	}

}
