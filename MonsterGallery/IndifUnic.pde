class IndifUnic extends Unicorn 
{
  
  public void giveGifts()
  {
    
      int a = int(random(2));
      
      if (a == 0 )
        IndifUnic.super.giveGifts();
        else
        println(" ");
    
  }
}
