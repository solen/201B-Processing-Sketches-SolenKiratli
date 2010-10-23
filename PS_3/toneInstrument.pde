class ToneInstrument implements Instrument
{
  Oscil sineOsc;
  ADSR  adsr;
  AudioOutput out;
  
  float A, D, S, R;
   
  ToneInstrument( float frequency, float amplitude, AudioOutput output )
  {
    out = output;
    sineOsc = new Oscil( frequency, amplitude, Waves.SINE );    
  }
  
  void setADSR(float att, float dec, float sus, float rel)
  {
    A = att;
    D = dec;
    S = sus;
    R = rel;
    adsr = new ADSR(0.5, A, D, S, R);
    sineOsc.patch( adsr );
  }
  
  /*void setADSR()
  { 
    adsr = new ADSR(0.5, A, D, S, R); 
    sineOsc.patch(adsr); 
  }*/
  
  /*
  public void Attack(float att) { A = att; }
  public void Decay(float dec) { D = dec ; }
  public void Sustain(float sus) { S = sus; }
  public void Release(float rel) { R = rel; }
  */
  void noteOn( float dur )
  {
    adsr.noteOn();
    adsr.patch( out );
   }
  
  void noteOff()
  {
    adsr.unpatchAfterRelease( out );
    adsr.noteOff();
  }
  
}
