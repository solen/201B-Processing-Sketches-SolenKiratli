abstract class ChaoticMonster extends Monster
{
  private String nonsense;
  
  public void chaoticActions()
  {
    println("The " + this.getClass().getSimpleName() + " is being chaotic:");
    makeChaos();
  }

  abstract public void makeChaos();
  
  public void render(int x, int y)
  {

    if (isMouseOver == true)
      {
      for(int i = 0; i < 500; i+=25)
        {
          int a = int(random(256));
          int b = int(random(256));
          tint(a, 256 - a, b);
        }
     
      }
    else
      tint(255,255,255);
  }

}
