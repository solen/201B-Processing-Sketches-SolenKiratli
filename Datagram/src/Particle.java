import processing.core.*;

public class Particle
{
  PVector loc;
  PVector vel;
  PVector acc;
  float r;
  float timer;
  float x, y;
  PApplet p;

  Particle(PVector l, PApplet papplet)
  {
    p = papplet;
    acc = new PVector(0,1/20,0);
    vel = new PVector(p.random(-5, 5),p.random(-5,5),0);
    loc = l.get();
    r = 5;
    timer = 100;
  }

  void run()
  {
    update();
    render();
  }

  // Method to update location
  void update()
  {
    vel.add(acc);
    loc.add(vel);
    timer -= 1.0;
    render();
    //x = loc.x;
    //y = loc.y;
  }

  // Method to display
  void render()
  {
    x = p.width/2;
    y = p.height/2;
    p.ellipseMode(p.CENTER);
    //stroke(255,timer);
    p.fill(100,timer);
    p.ellipse(loc.x,loc.y,r,r);
    //displayVector(vel,loc.x,loc.y,10);
  }

  // Is the particle still useful?
  boolean dead()
  {
    if (timer <= 0.0)
      return true;
        else
          return false;
      }

}
