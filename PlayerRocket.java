import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerRocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerRocket extends PlayerProjectile
{
    public PlayerRocket(int speed, int damage){
        super(speed,damage);
    }
    /**
     * Act - do whatever the PlayerRocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
    
    public void detectCollision(){
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (enemy != null){

            if(getWorld().getObjects(Marker.class).contains(marker)){
                getWorld().removeObject(marker);
            }
            getWorld().addObject(new PlayerExplosion(damage),getX(),getY());
            getWorld().removeObject(this);
            return;
        }

        Impassable wall = (Impassable) getOneIntersectingObject(Impassable.class);
        if (wall != null){
            if(getWorld().getObjects(Marker.class).contains(marker)){
                getWorld().removeObject(marker);
            }
            getWorld().addObject(new PlayerExplosion(damage),getX(),getY());
            getWorld().removeObject(this);
            return;
        }
        
        Passage passage = (Passage) getOneIntersectingObject(Passage.class);
        if(passage != null){
            if(getWorld().getObjects(Marker.class).contains(marker)){
                getWorld().removeObject(marker);
            }
            getWorld().addObject(new PlayerExplosion(damage),getX(),getY());
            getWorld().removeObject(this);
            return;
        }
    }
}
