package patterns.structural.bridge;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

interface Renderer_
{
  void renderCircle(float radius);
}

class VectorRenderer_ implements Renderer_
{
  @Override
  public void renderCircle(float radius)
  {
    System.out.println("Drawing a circle of radius " + radius);
  }
}

class RasterRenderer_ implements Renderer_
{
  @Override
  public void renderCircle(float radius)
  {
    System.out.println("Drawing pixels for a circle of radius " + radius);
  }
}

abstract class Shape_
{
  protected Renderer_ renderer;

  public Shape_(Renderer_ renderer)
  {
    this.renderer = renderer;
  }

  public abstract void draw();
  public abstract void resize(float factor);
}

class Circle extends Shape_
{
  public float radius;

  @Inject
  public Circle(Renderer_ renderer)
  {
    super(renderer);
  }

  public Circle(Renderer_ renderer, float radius)
  {
    super(renderer);
    this.radius = radius;
  }

  @Override
  public void draw()
  {
    renderer.renderCircle(radius);
  }

  @Override
  public void resize(float factor)
  {
    radius *= factor;
  }
}

class ShapeModule extends AbstractModule
{
  @Override
  protected void configure()
  {
    bind(Renderer_.class).to(VectorRenderer_.class);
  }
}

class BridgeDemo
{
  public static void main(String[] args)
  {
//    RasterRenderer_ rasterRenderer = new RasterRenderer_();
//    VectorRenderer_ vectorRenderer = new VectorRenderer_();
//    Circle circle = new Circle(vectorRenderer, 5);
//    circle.draw();
//    circle.resize(2);
//    circle.draw();

    // todo: Google Guice
    Injector injector = Guice.createInjector(new ShapeModule());
    Circle instance = injector.getInstance(Circle.class);
    instance.radius = 3;
    instance.draw();
    instance.resize(2);
    instance.draw();
  }
}
