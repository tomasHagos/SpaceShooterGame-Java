import greenfoot.*; 
public class Header extends World
{

    /**
     * Constructor for objects of class Header.
     * 
     */
    public Header()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
    }
    public void started(){
        Greenfoot.setWorld(new Instructions());
    }
}
