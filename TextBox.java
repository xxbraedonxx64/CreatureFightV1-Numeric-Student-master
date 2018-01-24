import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    private GreenfootImage img;
    private boolean border = false;
    private String text;
    private int fontSize;
    private Color foreground;
    private Color background;
    
    public TextBox( String message, int fs, boolean hasBorder, Color fg, Color bg)
    {
        fontSize = fs;
        border = hasBorder;
        foreground = fg;
        background = bg;
        text = message;
        
        img = new GreenfootImage( message, fontSize, foreground, background  );
        
        display();
    }
    
    /**
     * display show the following text message sizes of the current value
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void display()
    {
        if( border == true )
        {
            img.setColor( Color.BLACK );
            img.drawRect( 0, 0, img.getWidth() - 1, img.getHeight() - 1 );
        }
        setImage( img );
    }
    
    /**
     * getText returns the textbox from the current value
     * 
     * @param There are no parameters
     * @return the Text message from the current value
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * setText sets what text's font from the current value
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void setText( String message )
    {
        text = message;
        img = new GreenfootImage( text, fontSize, foreground, background );
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
