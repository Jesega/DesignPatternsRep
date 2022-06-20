package patterns.creational.prototype;

//Develop a deepcopy() mehod for the Line object

class Point
{
  public int x, y;
  
  public Point(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  
  public Point(Point other)
  {
	  x = other.x;
	  y = other.y;
  }
}

class Line
{
  public Point start, end;
  
  public Line(Point start, Point end)
  {
    this.start = start;
    this.end = end;
  }

  public Line deepCopy()
  {
    return new Line(new Point(start), new Point(end));
  }
}