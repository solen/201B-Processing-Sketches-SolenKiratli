class W extends ChaoticMonster {
 
 PImage WImg = loadImage("bush.jpg");
  
 public W()
 {
   super.nonsense = "I have already sucked your blood!!!";
 
 }
 
 public void makeChaos() {
   println(super.nonsense);
 }
 
 public void render(int x, int y){
     super.render(x,y);
    
     image(WImg, x,y,w,h);
   
   }
  
}
