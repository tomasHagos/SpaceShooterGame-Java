import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class Enemy extends Actor
{
    private int counter;
    private boolean movingDirection = false;
    private int firstPosition;
    private Shooting shooter = null;
    private boolean enemySet = false;
    private int life = 3;
    //the score variable is static because it should increment with each object
    public static int score = 0;

    
    public void act()
    
    {  
         MyWorld EnemysWorld = (MyWorld)this.getWorld();
         getWorld().showText(null,getX(), getY()+20);
        if(counter == 0 || movingDirection == true){
            firstPosition = getX();
            counter++;
        
        }
        movingDirection = EnemyMove(firstPosition, getX(),movingDirection);
        getWorld().showText("life "+life, getX(), getY()+20);
        life = removeBulletOrEnemy(life);
}
   public int removeBulletOrEnemy(int life){
   MyWorld EnemysWorld = (MyWorld)this.getWorld();
    if (isTouching(Shooting.class))
{
    removeTouching(Shooting.class);
    life--;
    if(life == 0) {
         getWorld().showText(null, getX(), getY()+20);
         score ++;
         EnemysWorld.removeEnemy(this);
    }
}
return life;
}
            
    
    public boolean EnemyMove(int firstposition,int position2,boolean movingDirection){
        if(firstposition >= 590 || !movingDirection){
            firstposition = getX() * -1;
         }
         if(firstposition < 0 && position2 > 10){
            move(-2);
        }
        else if(position2 < 590){
            move(2);
            return true;
            }
            return false;
            
    }
    
    public static int getScore(){
        return score;
    }
    public static void setScore(){
    score = 0;
}



  
}
