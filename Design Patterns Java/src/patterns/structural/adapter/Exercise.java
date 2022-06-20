package patterns.structural.adapter;

//You are given a Rectangle interface and an extension method on it. 
//Try to define a SquareToRectangleAdapter that adapts the Square to the IRectangle interface.

class Square
{
	public int side;

	public Square(int side)
	{
		this.side = side;
	}
}

interface Rectangle
{
	int getWidth();
	int getHeight();

	default int getArea()
	{
		return getWidth() * getHeight();
	}
}

class SquareToRectangleAdapter implements Rectangle
{
	private int width, height;
	
	public SquareToRectangleAdapter(Square square)
	{
		width = square.side;
		height = square.side;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
