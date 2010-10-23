/* Solen Kiratli DiCicco
 */
import ddf.minim.*;
import ddf.minim.ugens.*;
import controlP5.*;
Minim minim;

ControlP5 cp5; 
AudioOutput out;
ToneInstrument inst1;

public int play = 0;
float a = 0.5;
float d = 0.5;
float s = 0.5;
float r = 0.5;
int freq;

void setup()
{
  minim = new Minim( this );
  out = minim.getLineOut( Minim.MONO, 2048 );

  size(750,400);
  smooth();
  
   cp5 = new ControlP5(this);
   cp5.begin(10,10);
   cp5.addSlider("attack",0.01, 1).linebreak();
   cp5.addSlider("decay",0.01, 1).linebreak();
   cp5.addSlider("sustain",0.5, 5).linebreak();
   cp5.addSlider("release",0.5, 5).linebreak();
   cp5.addToggle("play", false, 10, 100, 10, 10);
   cp5.end();   

  //for( int i = 1; i < 60; i++ )
   //callInstruments();
}

void attack(float attack)  { a = attack; }
void decay(float decay)  { d = decay; }
void sustain(float sustain) { s = sustain; }
void release(float release) { r = release; }


void callInstruments() 
{
  int i = 0;
  out.pauseNotes();
  
     freq = int(random(5, 10)) * 110;
 
     inst1 = new ToneInstrument(freq/4, 0.5, out);
     inst1.setADSR(a, d, s, r);
     
     out.playNote(i, a+d+s+r, inst1); 
     
  
  out.resumeNotes();
     
}

void draw()
{
  background(255);
  
  fill(100, 100);
  ellipse(150, 200, a*100, a*100);
  
  fill(200, 200);
  ellipse(300, 200, d*100, d*100);
  
  fill(120, 50);
  ellipse(450, 200, s*100, s*100);
  
  fill(50, 120);
  ellipse(600, 200, r*100, r*100);
 
}

void play(boolean b) 
{
  if(b==true) 
  {
    callInstruments();
  } 
}


void stop()
{
  out.close();
  minim.stop();
  super.stop();
}

