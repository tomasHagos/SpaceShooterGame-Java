import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Rewards extends Actor
{
    public void act()
    {
       setLocation(getX(), getY()+8);
       if(isAtEdge()){
        getWorld().removeObject(this);
        }
    }
}