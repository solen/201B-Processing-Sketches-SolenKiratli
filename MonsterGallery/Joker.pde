

class Joker extends AngryMonster {
 
 PImage vampireImg = loadImage("joker.jpg");
  
 public Joker() {
   super.warCry = "Kill the Batman!";
   super.in = minim.loadFile("batman.wav");
   
 }
 
 public void yell() {
   println(super.warCry);
    
 }
 
 public void render(int x, int y){
     super.render(x,y);
    
     image(vampireImg, x,y,w,h);
   
   }
  
}

  
