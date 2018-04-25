/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package areUThere;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author antoniomejorado
 */
public abstract class Item {
    protected int x;        // to store x position
    protected int y;        // to store y position
    protected int width;    // to store width
    protected int height;   // to store height
    
    /**
     * Set the initial values to create the item
     * @param x <b>x</b> position of the object
     * @param y <b>y</b> position of the object
     * @param width <b>y</b> dimension of the object
     * @param height <b>y</b> dimension of the object
     */
    public Item(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Get x value
     * @return x 
     */
    public int getX() {
        return x;
    }

    /**
     * Get y value
     * @return y 
     */
    public int getY() {
        return y;
    }
    
     /**
     * Get y value
     * @return width
     */
    public int getWidth() {
        return width;
    }
    
     /**
     * Get y value
     * @return height 
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set x value
     * @param x to modify
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set y value
     * @param y to modify
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Set y value
     * @param width to modify
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * Set y value
     * @param height to modify
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    public boolean intersects(Object obj) {
        //check if object is item and if this rectangle intersects obj rectangle
        return (obj instanceof Item && 
                this.getBounds().intersects(((Item) obj).getBounds()));
    }
    
    //for interactions (text)
    public boolean intersects(Object obj, boolean type) {
        //check if object is item and if this rectangle intersects obj rectangle
        return (obj instanceof Item && this.getBounds(type).intersects(((Item) obj).getBounds()));
    }
    
    private Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    //for interactions (text)
    private Rectangle getBounds(boolean type) {
        return new Rectangle(getX()-5, getY()-5, getWidth()+10, getHeight()+10);
    }
    
    /**
     * To update positions of the item for every tick
     */
    public abstract void tick();
    
    /**
     * To paint the item
     * @param g <b>Graphics</b> object to paint the item
     */
    public abstract void render(Graphics g);
}
