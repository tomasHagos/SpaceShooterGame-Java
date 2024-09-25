import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reward2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reward2 extends Rewards
{
    /**
     * Act - do whatever the Reward2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       setLocation(getX(), getY()+8);
       remove();
    }
    public void remove(){
        if(isAtEdge()){
        getWorld().removeObject(this);
        }
    }
}