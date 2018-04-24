/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areUThere;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author davidacevedo
 */
public class Door extends Item {
    
    //the door connects the following two rooms
    private int nextRoom;
    private int nextX;
    private int nextY;

    public int getNextX() {
        return nextX;
    }

    public void setNextX(int nextX) {
        this.nextX = nextX;
    }

    public int getNextY() {
        return nextY;
    }

    public void setNextY(int nextY) {
        this.nextY = nextY;
    }

    public int getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(int nextRoom) {
        this.nextRoom = nextRoom;
    }
    
    public Door(int x, int y, int width, int height, int nextRoom, int nextX, int nextY) {
        super(x, y, width, height);
        this.nextRoom = nextRoom;
        this.nextX = nextX;
        this.nextY = nextY;
    }
    
    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(150,100,50));
        g.fillRect(this.x, this.y, this.getWidth(), this.getHeight());
    }
    
}
