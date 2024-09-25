import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 this enemy has only one life and moves fast
 */

public class Enemy2 extends Enemy
{
    private int life = 1;
    private boolean rightOriented = false;
    private boolean leftOriented = false;
    private int count=0;
    private boolean isremoved = false;

    public void act()
    
    {  
         getWorld().showText(null, getX(), getY()+30);
         MyWorld EnemysWorld2 = (MyWorld)this.getWorld();
        if(count ==0){
        if(getX() > 500) {rightOriented = true;}
        else {leftOriented = true;}
        count=1;
    }
        
    if(rightOriented) 
    {
    move(-3);
    }
    else
    {
       move(3); 
    }
         getWorld().showText("life "+life, getX(), getY()+30);
         life = removeBulletOrEnemy(life);
         if(life==0) isremoved = true;
       if(!isremoved)
       {
       if(isAtEdge()){
           getWorld().showText(null, getX(), getY()+30);
           EnemysWorld2.removeEnemy2(this,false);
        }
    }
    }
     
    @Override 
    public int removeBulletOrEnemy(int life){
   MyWorld EnemysWorld2 = (MyWorld)this.getWorld();
    if (isTouching(Shooting.class))
{
    removeTouching(Shooting.class);
    life--;
    if(life == 0) {
         getWorld().showText(null, getX(), getY()+30);
         score +=1;
         EnemysWorld2.removeEnemy2(this,true);
    }
}
return life;
}
}
