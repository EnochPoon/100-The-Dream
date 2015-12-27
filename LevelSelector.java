import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;
/**
 * Write a description of class LevelSelector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelector extends World
{
    //variables for game data
    String[] completedLevels;
    Player player; //Stores the player stuff
  

    // Buttons for level selection
    private Level1 one = new Level1();
    private Level2 two = new Level2();
    private Level3 three = new Level3();
    private Level4 four = new Level4();
    private Level5 five = new Level5();
    
    boolean newGame=false; //if it is a new game or not
    
    /**
     * Constructor for objects of class LevelSelector.
     * 
     */
    public LevelSelector()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1,false); 

        // Add all the level selector buttons 
        addObject (one, 96, 481);
        addObject (two, 222, 481);
        addObject (three, 345, 481);
        addObject (four, 469, 481);
        addObject (five, 587, 481);
        newGame = !loadData();
    }

    public void act(){
        // Check for mouse click of each buttons to determine level selection
        MouseInfo mouse = Greenfoot.getMouseInfo();
        int level=-1;
        if (Greenfoot.mouseClicked(one)) {
            level=1;
        } else if (Greenfoot.mouseClicked(two)) {
            level=2;
        } else if (Greenfoot.mouseClicked(three)) {
            level=3;
        } else if (Greenfoot.mouseClicked(four)) {
            level=4;
        } else if (Greenfoot.mouseClicked(five)) {
            level=5;
        }
        if(level >0){
            if (newGame){
                Greenfoot.setWorld (new Map(level));
            }else{
                Greenfoot.setWorld (new Map(level,player));
            }
        }
    }
    
    
    public boolean loadData(){ //loads previous save data
        File file = new File("data/player_data.txt");
        if(!file.exists()){ //there has been no save data
            
            return false; //load data failed
        } 
        
        try{ //there is save data, now read it
            FileInputStream fileIn = new FileInputStream("data/player_data.txt");
            ObjectInputStream objIn = new ObjectInputStream (fileIn);
            
            PlayerData playerData = (PlayerData)objIn.readObject();
            player = new Player(playerData);
           
            fileIn.close();
            objIn.close();
        }catch (Exception ex){ //start new game if we can't read the file
            ex.printStackTrace();
            file.delete(); //remove the unreadable file
            return false;
        }
        return true;
    }

}
