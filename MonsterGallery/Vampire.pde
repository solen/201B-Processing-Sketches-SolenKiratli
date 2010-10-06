
class Vampire extends AngryMonster {
 
 PImage vampireImg = loadImage("vampire.jpeg");
  
 public Vampire() {
 super.warCry = "I vant to suck your blood!";
 }
 
 public void yell() {
   println(super.warCry);
 }
 
 public void render(int x, int y){
     super.render(x,y);
    
     image(vampireImg, x,y,w,h);
   
   }
  
}
