
import processing.core.*;


public class Circle extends Geometry
{

    float r = (float)(Math.random() * 50);
    float x, y, opacity, fill;
    PApplet p = new PApplet();;

    
     public Circle()
    {
       x = (float)(Math.random()) * p.width - r;
       y = (float)(Math.random()) * p.height - r;
       opacity = (int)(Math.random() * 256);
       fill = (int)(Math.random() * 256);
    }
     

    public double calcArea()
    {
        area = Math.PI * r * r;
        return area;
    }


    public void render()
    {
       p.fill(fill, opacity);
       p.ellipse(x, y, r*2, r*2);
        
    }


}
