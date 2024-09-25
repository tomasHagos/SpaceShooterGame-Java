import greenfoot.*; 
import java.util.ArrayList;


public class Shooting extends Actor
{
    //this is the enemies life count
    private static int life = 3;
    public boolean enemyShot = false;
    private Enemy enemy;
    public static int  scoreCounter=0;
    public void act()
    { 
        //this moves the bullet upwards
        setLocation(getX(), getY() - 6);
        if(isAtEdge()) getWorld().removeObject(this);
    }
    } 
        
