import ddf.minim.*;

List monsters;
Minim minim;


public void setup() {
  size(600,600);
  minim = new Minim(this);  
  monsters = new ArrayList();

  monsters.add(new Vampire());
  monsters.add(new Unicorn());
  monsters.add(new W());
  monsters.add(new IndifUnic());
  monsters.add(new Joker()); 
}

public void draw() 
{
  for (int i = 0; i < monsters.size(); i++) 
  {
  
    Monster m = (Monster) monsters.get(i);
    
    int xpos = i * 200; int ypos = 200 * (i/3);
    
    if (xpos > 400)
        xpos -= 600 * (i/3);
    
   
    m.checkIfMouseOver(xpos, ypos, mouseX, mouseY);
  
    m.render(xpos, ypos);
  }  
}

public void mousePressed()
{
  for (int i = 0; i < monsters.size(); i++) {
    Monster m = (Monster) monsters.get(i);
  
    if (m.isMouseOver == true)
    {
      if (m instanceof FriendlyMonster)
      {
        ((FriendlyMonster)m).friendlyActions();
      }
      else if (m instanceof AngryMonster)
      {
        ((AngryMonster)m).angryActions();   
      }
      else if (m instanceof ChaoticMonster)
      {
        ((ChaoticMonster)m).chaoticActions();
      }
      else if (m instanceof IndifUnic)
      {
        ((IndifUnic)m).giveGifts();
      }
      else if (m instanceof Joker)
      {
        ((Joker)m).angryActions();
      }
    
      println("\n");
    }
    
    
  }
}


  
 

