// Why is the gifts list private?

abstract class FriendlyMonster extends Monster {
  private List gifts = new ArrayList();

// what does .getClass().getSimpleName() return? This.getClass() would be FriendlyMonster?
//So, FriendlyMonster.getSimpleName() would be the string 'name' of the particular instance?
  public void friendlyActions()
  {
    println("The " + this.getClass().getSimpleName() + " is being friendly:");
    
    giveGifts(); 
    
  }

  //Whay is this empty? Why is it abstract?
  abstract public void giveGifts();

  public void render(int x, int y)
  { 
    if (isMouseOver == true)
      tint(0,255,0);
    else
      tint(255,255,255);
  }
}

