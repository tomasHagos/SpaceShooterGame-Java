import greenfoot.*;
import java.util.ArrayList;
import java.util.Random; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo
public class MyWorld extends World
{
    private GreenfootImage scrollBackground;
    private int offset;
    private int timer = 0;
    private ArrayList<Obstacle> obList;;
    private ArrayList<Enemy> enemyList;
    private ArrayList<Enemy2> enemyList2;
    private Obstacle obstacle;;
    private Enemy enemy;
    private Enemy2 enemy2;
    private Rocket myRocket;
    private int shootingDelay = 0;
    private boolean shot;
    private Random RNG;
    private int PlayerLife;
    private ArrayList<PlayerLife> lifes;
    private boolean heart1,heart2,heart3;
    private Rewards reward;
    private Reward2 reward2;
    private int RewardCount,count=0,rewardTime;
    private int extraLifeTime = 0,lifeTimeCount,count2=0;
    private int EnemyDelay = 0;
    private int Enemy2Delay;
    private  Score score;
    private Reward3 reward3;
    private int loseLife = 0;
    private int loseLifeCount;
    private int count3 = 0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        this.setBackground(new GreenfootImage("spaceimage (1).jpg"));
        scrollBackground = new GreenfootImage("spaceimage (1).jpg");
        
         myRocket = new Rocket();
        this.addObject(myRocket,200,500);
        
        obstacle = new Obstacle();
        obstacle.turn();
        this.addObject(obstacle, 400,100);
        
        obList = new ArrayList<>();
        obList.add(obstacle);
        enemyList = new ArrayList<>();
        enemyList2 = new ArrayList<>();
        enemy = new Enemy();
        RNG = new Random();
        lifes = new ArrayList<>();
        PlayerLife life = new PlayerLife();
        PlayerLife life3 = new PlayerLife();
        PlayerLife life2 = new PlayerLife();
        lifes.add(life3);
        lifes.add(life2);
        lifes.add(life);
        this.addObject(life,500,25);
        this.addObject(life2,470,25);
        this.addObject(life3,440,25);
        showText("Lifes:",350,25);
        heart1 = false;
        heart2 = false;
        heart3 = false;
        PlayerLife = 3;
        score = new Score();
        this.addObject(score,50,50);

    }
        public void act(){ 
            if(enemyList.size()==0)EnemyDelay++;
             if(enemyList2.size()==0)Enemy2Delay++;
            if(count==0){
            RewardCount = RNG.nextInt(700) + 500;
            count++;
        }
        if(count2==0){
            lifeTimeCount =  RNG.nextInt(1000) + 500;
            count2++;
        }
        if(count3==0){
        loseLifeCount = RNG.nextInt(1000)+500;
        count3++;
    }
        rewardTime++;
        extraLifeTime++;
        loseLife++;
        if(rewardTime==RewardCount){
            reward = new Rewards();
            this.addObject(reward,RNG.nextInt(600),0);
            count = 0;
            rewardTime=0;
        }
        if(extraLifeTime ==lifeTimeCount){
            extraLifeTime = 0;
            count2 = 0;
            //don't give the player extra life if they already have 5 lifes
            if(myRocket.getPlayerLife() < 5){
            Reward2 addLife = new Reward2();
            this.addObject(addLife,RNG.nextInt(600),0);
        }
          }
          if(loseLife == loseLifeCount){
              reward3 = new Reward3();
              this.addObject(reward3,RNG.nextInt(600),0);
              count3=0;
              loseLife=0;
            }
        
        
            if(enemyList.size() == 0 && (EnemyDelay>200)){
                enemy = new Enemy();
                this.addObject(enemy,RNG.nextInt(),RNG.nextInt(400)+20);
                enemyList.add(enemy);
                EnemyDelay=0;
                }
                
            if(enemyList2.size()==0 && (Enemy2Delay > 200)){
                enemy2 = new Enemy2();
                this.addObject(enemy2, RNG.nextInt()+100,RNG.nextInt(400)+20);
                enemyList2.add(enemy2);
                Enemy2Delay = 0;
            } 
        timer += 1;
        offset += 8;
        //enemy.followPlayer(myRocket.getX());
        if(offset > 0) offset -= 600;
        scrollBackground(offset);
    boolean isadded = addObstacles(timer);
            //addObstacles(timer);
    if(isadded)timer=0;
    //this checks if the obstacles are at the edge. if true remove the objects 
    //remove(obList);
    if(shootingDelay <= 0){
    if(myRocket.isShooting()){
        shot = true;
        Shooting bullet1 = new Shooting();
        this.addObject(bullet1, myRocket.getX(), myRocket.getY()+2);
        Greenfoot.playSound("ShootingSound.wav");
        shootingDelay = 30;
        }
    }
    shootingDelay--;
    if(myRocket.getaddLife() == true){
        PlayerLife life4 = new PlayerLife();
        this.addObject(life4, lifes.get(lifes.size()-1).getX()+30,25);
        lifes.add(lifes.size(),life4);
        PlayerLife = lifes.size();
        myRocket.setAddLife(false);
    }
    if(myRocket.getPlayerLife()==0){
        Greenfoot.stop();
    }
    if(PlayerLife != myRocket.getPlayerLife()){
        if(lifes.size() > 0){
        this.removeObject(lifes.get(lifes.size()-1));
        lifes.remove(lifes.size()-1);
        PlayerLife = lifes.size();
        }
    }
    

    
}
    public void stopped(){
        showText("Game Over", 350,200);
        showText("Score: " + Enemy.getScore(), 350,250);
        showText("Coins:" + myRocket.getCoins(),350,300);
        Greenfoot.playSound("gameOver.wav");
        Enemy.setScore();
        removeObject(myRocket);
    }
      private void scrollBackground(int position)
      {
        GreenfootImage bg = getBackground();
        bg.drawImage(new GreenfootImage("spaceimage (1).jpg"),0,offset);
       }
       
    private boolean addObstacles(int timer){
      if(timer > 300){
        Obstacle newObs = new Obstacle();
        newObs.turn();
        obList.add(newObs);
        this.addObject(newObs,Greenfoot.getRandomNumber(450)+100,-200);
        timer = 0;
        return true;
    }
    return false;
}

 public  void removeEnemy(Enemy enemy) {
        enemyList.remove(enemy);
        Greenfoot.playSound("Explosion.wav");
        removeObject(enemy);
    }
 public void removeEnemy2(Enemy2 enemy2,boolean isshot){
        enemyList2.remove(enemy2);
        if(isshot){
        Greenfoot.playSound("Explosion.wav");
    }
        removeObject(enemy2);
      }   
}


