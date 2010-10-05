int num  = 390000;
float[] x = new float[num];
float[] y = new float[num];
PImage img;


void setup()
{
  size(800, 500);
  img = loadImage("shadows.jpg");
  
  for (int i = 0; i < num; i++)
  {
    x[i] = random(width);
    y[i] = random(height);  
  }
  
  stroke(255);
  smooth();
}


void draw()
{
  background(0);
  
  for (int i = 0; i < num; i++)
  {
    color c = img.get(int(x[i]), int(y[i]));
    float b = brightness(c) / 255.0;
    float speed = pow(b, 2) + 0.05;
    //float speed = mouseX + 0.05;
    x[i] += speed;
    y[i] += speed;
    
    if (x[i] > width)
    {
      x[i] = 0;
      y[i] = random(height);
    }
    
    point(x[i], y[i]);
   
  }
}


