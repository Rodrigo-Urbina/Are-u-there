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
    private int room1;
    private int room2;

    public int getRoom1() {
        return room1;
    }

    public void setRoom1(int room1) {
        this.room1 = room1;
    }

    public int getRoom2() {
        return room2;
    }

    public void setRoom2(int room2) {
        this.room2 = room2;
    }
    
    public Door(int x, int y, int width, int height, int room1, int room2) {
        super(x, y, width, height);
        this.room1 = room1;
        this.room2 = room2;
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
