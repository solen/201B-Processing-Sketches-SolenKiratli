import processing.core.*;
import java.util.*;
import ddf.minim.*;
import ddf.minim.ugens.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.analysis.*;


public class MyEvent extends PApplet
{
    Minim minim;
    AudioOutput out;
    int freq;
    PlayOsc Inst1;
    float amp;
    float avg;
    List particles;
    PVector origin;
    int num;
    int outGoing;
    String sent;
    DatagramServer server;
    public static boolean sendMessage;

    public static String incoming;
    
    public static int incomingIntx = 200;
   // public static int incomingInty;
    public static boolean start = false;

    public void setup()
    {
        size(1024, 640);
        fill(255,0, 0, 102);
        smooth();
        noStroke();
        num = 50;
        sendMessage = false;

        server = new DatagramServer();
        server.start();

        minim = new Minim(this);
        minim.debugOn();
        out = minim.getLineOut( Minim.MONO, 2048 );
        //freq = (int)(random(110,880));
        //out.pauseNotes();

        outGoing = (int)random(1,9);
        sent = Integer.toString(outGoing);

        for(int i = 0; i < 100; i++)
        {
              freq = outGoing * 80;
              Inst1 = new PlayOsc(freq, 1/2, out);
              freq++;
            //Inst1.patch(out);
              out.playNote(0, 1, Inst1);
        }

        out.resumeNotes();

        num = incomingIntx;
        origin = new PVector(width/2, height/2, 0);
                particles = new ArrayList();

     }

public void draw()
{
  background(0);
  stroke(120);

  Particle p;

  if (start == true)
  {
        particles = new ArrayList();
        for (int i = 0; i < num; i++)
        {
            Particle par = new Particle(origin, this);
            particles.add(par);
            par.render();
         }
        start = false;
  }
  for (int i = 0; i < particles.size() -1; i++)
  {
      p = (Particle)particles.get(i);
      p.run();

      if (p.dead() && sendMessage)
      {
          new DatagramClient(sent);
          //exit();
          sendMessage = false;
      }
  }


}

//public void stopIt()
//{ start == false;}


public static void received()
{

    println("Message received");
    println("The message is: " + incoming);
    println("Int one: " + incomingIntx + " Int two: " + incomingIntx);

    start = true;
    sendMessage = true;
    println("incomingIntx: " + incomingIntx);
}


public void stop()
{
  out.close();
  minim.stop();
  super.stop();
}

public static void main(String[] args)
  {
    PApplet.main(new String[] {"MyEvent"});
  }

}
