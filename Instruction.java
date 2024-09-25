import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Instruction extends Actor
{
    private int time=0;
    public Instruction(){
    }
    public void act()
    {
        time++;
        if(Greenfoot.isKeyDown("s")){
        Greenfoot.setWorld(new MyWorld());
    }
    if(time < 30){
    Greenfoot.playSound("introSound.wav");
}

}
}