import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pikachu extends Creature
{
    public Pikachu( World w )
    {
        super(700, false, "Electric");
        getImage().scale( 150, 100);
        w.addObject( getHealthBar(), 100, 25 );
    }
    
    public void act() 
    {
        // Add your action code here.
        CreatureWorld playerWorld = ( CreatureWorld )getWorld();
        
        if( getHealthBar().getCurrent() <= 0 )
        {
            getWorld().showText("Pikachu has fainted…", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
            Greenfoot.delay(30);
            if( playerWorld.getNewTwoCreature(1).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(0);
                playerWorld.changeTurn(false);
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                getWorld().removeObject(this);
            }
            else if( playerWorld.getNewTwoCreature(2).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(1);
                playerWorld.changeTurn(false);
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                getWorld().removeObject(this);
            }
        }
    }    
    
    /**
     * attack the creature attacks the enemy creature doing damage and has there weakness and what there strong against
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
        public void attack ( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature enemy = world.getPlayerOne();
        String enemyType = enemy.getType();
        attackAnimation();
        if( idx <= 0 )
        {
            enemy.getHealthBar().add( -30 );
        }
        else
        {
            if( enemyType.equalsIgnoreCase("Rock") ) 
            {
                enemy.getHealthBar().add( 0 );
                getWorld().showText("It has no effect...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                Greenfoot.delay(30);
            }
            else if( enemyType.equalsIgnoreCase("Grass") ) 
            {
                enemy.getHealthBar().add( -65/2 );
                getWorld().showText("It's not very effective...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                Greenfoot.delay(30);
            }
            else
            {
                enemy.getHealthBar().add( - 70 );
            }
        }
        world.changeTurn(true);
    }
    
    /**
     * attackAnimation has the Creature move is self when it attacks
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        for( int i = 0; i < 15; i++ )
        {
            setLocation( getX() - 1 ,getY() + 2 );
            Greenfoot.delay(1);
        }
        setLocation( originalX, originalY );
    }
    
    /**
     * switchCreature the Creature can switch out with other Creature and when the creature faints and shows a message
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void switchCreature( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature switchCreature;
        if( idx == 0 )
        {
            switchCreature = world.getNewTwoCreature(1);
        }
        else
        {
            switchCreature = world.getNewTwoCreature(2);
        }
        
        if( switchCreature.getHealthBar().getCurrent() <= 0 )
        {
            JOptionPane.showMessageDialog( null, "This creature has fainted! Please select a different creature." );
        }
        else
        {
            while( getX() < getWorld().getWidth() - 1 ) 
            {
                setLocation( getX() + 5, getY() );
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            
            if( idx == 0 )
            {
                world.changePlayerTwo("Lapras");
            }
            else
            {
                world.changePlayerTwo("Pidgeot");
            }
            switchCreature.switchedIn();
            world.changeTurn(true);
        }
    }
    
    /**
     * switchIn Gets The Pikachu Image Then Moves In To The Current Value When Seleted
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void switchedIn()
    {
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        while( getX() > 325 )
        {
            setLocation( getX() - 5, getY() );
            Greenfoot.delay(2);
        }
    }
}
