package patterns.structural.bridge;

interface Renderer {
	public abstract String whatToRenderAs();
}

class VectorRenderer implements Renderer {
	@Override
	public String whatToRenderAs() {
		return "lines";
	}
}

class RasterRenderer implements Renderer {
	@Override
	public String whatToRenderAs() {
		return "pixels";
	}
}

abstract class Shape {
	protected Renderer renderer;
	
	public Shape(Renderer renderer)
	{
		this.renderer = renderer;
	}
	
	public abstract String getName();
	public String toString()
	{
		return 	"Drawing " + this.getName() + " as " + renderer.whatToRenderAs();
	}
}

class Triangle extends Shape {
	public Triangle(Renderer renderer) {
		super(renderer);
	}

	@Override
	public String getName() {
		return "Triangle";
	}
}

class Square extends Shape {
	public Square(Renderer renderer) {
		super(renderer);
	}

	@Override
	public String getName() {
		return "Square";
	}
}
