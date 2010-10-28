
import processing.core.*;


public class Circle extends Geometry
{

    float r = (float)(Math.random() * 50 + 10);
    float x, y, opacity, fill;
    PApplet p;

    
     public Circle(PApplet papplet)
    {
       p = papplet;
       //x = (float)(Math.random()) * p.width - (r * 3);
       x = p.random(r, p.width - r);
       //y = (float)(Math.random()) * p.height - r * 3;
       y = p.random(r, p.height - r);
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
       p.smooth();
       p.noStroke();
       p.fill(fill, opacity);
       p.ellipse(x, y, r*2, r*2);
        
    }


}
