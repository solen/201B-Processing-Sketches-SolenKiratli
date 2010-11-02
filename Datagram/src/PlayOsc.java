import processing.core.*;
import ddf.minim.*;
import ddf.minim.ugens.*;

class PlayOsc extends PApplet implements Instrument
{
  AudioOutput out;
  Oscil sineOsc;
  Multiplier  multiplyGate;
  PApplet p;


  PlayOsc( float frequency, float amplitude, AudioOutput output )
  {
    out = output;

    sineOsc = new Oscil( frequency, amplitude, Waves.SINE );
    multiplyGate = new Multiplier( 0 );
    sineOsc.patch( multiplyGate );
  }


  public void noteOn( float dur )
  {
    multiplyGate.setValue(1);
    multiplyGate.patch( out );

   }

  public void noteOff()
  {
    multiplyGate.setValue( 0 );
    multiplyGate.unpatch( out );
  }
}

