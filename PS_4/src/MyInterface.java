import processing.core.*;
import controlP5.*;
import java.util.*;

public class MyInterface extends PApplet
{
   ControlP5 cp5;
   ListBox l;
   Numberbox n;
   Button b;
   Textlabel t;
   
   Float totalArea;
   public int number = 2;

   Map<String, List<Geometry>> shapeMap = new HashMap<String, List<Geometry>>();
   
   List<Geometry> circles = new ArrayList<Geometry>();
   //List<Geometry> pentagons = new ArrayList<Geometry>();
   //List<Geometry> hexagons = new ArrayList<Geometry>();
   

public void setup()
{
  size(800,400);
  smooth();
  noStroke();

  cp5 = new ControlP5(this);
  cp5.setControlFont(new ControlFont(createFont("Helvetica",8), 8));
  cp5.begin(10,10);
  l = cp5.addListBox("select shape", 20, height-60, 100, 100);
  l.actAsPulldownMenu(true);
  l.addItem("Circle", 1);
  l.addItem("Pentagon", 2);
  l.addItem("Hexagon", 3);
  n = cp5.addNumberbox("number", 140, height-40, 30, 20);
  b = cp5.addButton("render", 100, 190, height-40, 40, 20);
  t = cp5.addTextlabel("label", "THE TOTAL AREA IS " + totalArea, 250,height-30);
  cp5.end();
  t.setColorValue(0xffcccccc);
  n.setMax(50);
  n.setMin(1);

  for (int i = 0; i < number; i++)
  {
      circles.add(new Circle());
  }
  
  shapeMap.put("Circles", circles);

}



 public void draw()
 {
    background(0);

    if((l.value() == 1) &&(b.booleanValue() == true))
    {
        List<Geometry> currentList = shapeMap.get("Circles");

        for (int i = 0; i < number; i++)
        {
            circles.get(i).render();
        }
    }
    
  }



public static void main(String[] args)
  {
    PApplet.main(new String[] {"MyInterface"});
  }

}
