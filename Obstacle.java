import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 100;
    public void act() 
    {
         MyWorld ObstaclesWorld = (MyWorld)this.getWorld();
         move(-8); 
         if(isAtEdge()) getWorld().removeObject(this);
    }
    public void turn(){
    turn(-90);
}
}