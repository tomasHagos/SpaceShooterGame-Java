import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Reward3 extends Rewards
{
    private int counter =0;
    
    public void act()
    {
        if(counter == 0){
        getImage().scale(20,20);
            counter = 1;
        } 
        setLocation(getX(), getY()+8);
        if(isAtEdge()){
        getWorld().removeObject(this);
        }
    }
}
