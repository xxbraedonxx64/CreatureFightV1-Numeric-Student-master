import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    private HealthBar creatureBar;
    private int healthNumber;
    private boolean playerOneCreature;
    private String type;
    
    public Creature()
    {
        healthNumber = 500;
        playerOneCreature = true;
        creatureBar = new HealthBar ( healthNumber, healthNumber, 10 );
        
    }

    public Creature( int health, boolean isPlayerOne, String creatureType )
    {
        healthNumber = health;
        creatureBar = new HealthBar ( healthNumber, healthNumber, 10 );
        type = creatureType;
        playerOneCreature = isPlayerOne;
    }
    
    /**
     * getType get the Creatures type 
     * 
     * @param There are no parameters
     * @return the creature's type 
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * getHealthBar get the Creatures health bar
     * 
     * @param There are no parameters
     * @return the creature's health bar
     */
    protected HealthBar getHealthBar()
    {
        return creatureBar;
    }
    
    /**
     * getWhetherPlayerOne checks if its playerone's turn or playertwo's turns
     * 
     * @param There are no parameters
     * @return the 
     */
    public boolean getWhetherPlayerOne()
    {
        return playerOneCreature;
    }
    
    public void attack( int idx )
    {
        //empty method that will get overriden in subclasses}    }
    }
    
    public void switchCreature( int idx )
    {
        //empty method that will get overriden in subclasses}    }
    }
    
    public void switchedIn()
    {
        //empty method that will get overriden in subclasses}    }
    }
    
    /**
     * act will complete actions that the Creature object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        //empty method that will get overriden in subclasses
    }   
}

