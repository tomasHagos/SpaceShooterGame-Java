import greenfoot.*;
import java.util.Random;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean isShooting = false;
    private int counter = 0;
    private int shootDelay;
    private int playerLife = 3;
    private int coins;
    private boolean addLife = false;
    private boolean removeLife = false;
    public void act() 
    {
         getWorld().showText(null,50,100);
         if(Greenfoot.isKeyDown("left")){
             this.setLocation(getX()-5,getY());
            }
            
          if(Greenfoot.isKeyDown("right")){
             this.setLocation(getX()+5,getY());
            }   
          if(Greenfoot.isKeyDown("d")){
            isShooting = true;
        } 
        if(isTouching(Obstacle.class)){
            Greenfoot.playSound("Explosion2.wav");
            playerLife--;
            removeTouching(Obstacle.class);
    }
            
           if(isTouching(Rewards.class)){
               if(isTouching(Reward2.class)){
                    Greenfoot.playSound("lifeCollector.wav");
                    removeTouching(Reward2.class);
                    playerLife++;
                    addLife = true;
        }
        else if(isTouching(Reward3.class)){
            Greenfoot.playSound("losingLife.wav");
            removeTouching(Reward3.class);
            playerLife--;
            }
        else{
               Greenfoot.playSound("coinSound.wav");
               coins++;
               removeTouching(Rewards.class);
            }
        }
            getWorld().showText("Coins:"+coins,50,100);
        
        if(isTouching(Reward2.class)){
            removeTouching(Reward2.class);
            }
    }
    public boolean isShooting(){
        if(isShooting && counter == 0){
        counter +=1;
        return true;
    }
       else{
           counter = 0;
           isShooting = false;
        return false;
    }
}

public int getPlayerLife(){
return playerLife; 
}
public int getCoins(){
return coins;
}
public boolean getaddLife(){
    return addLife;
}
public void setAddLife(boolean input){
    addLife = input;
}



}
