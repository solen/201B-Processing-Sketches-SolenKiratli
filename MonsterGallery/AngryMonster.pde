abstract class AngryMonster extends Monster {
private String warCry;
AudioPlayer in;  

  public void angryActions()
  {
    println("The " + this.getClass().getSimpleName() + " is being angry:");
    in.play();
    yell();
  }

  
  abstract void yell();

  public void render(int x, int y)
  {

    if (isMouseOver == true)
      tint(255,0,0);
    else
      tint(255,255,255);
  }
}

