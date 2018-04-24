/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areUThere;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
/**
 *
 * @author Rodrigo
 */
public class Room {
    
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    private Game game;
    private boolean passed; //flag to check if the puzzle has already been passed
    private ArrayList<TestObstruction> obstructions; //list of all objects in room
    private ArrayList<Door> doors;  // to store doors
    
    public Room (int width, int height, Game game) {
        this.game = game;
        this.height = height;
        this.width = width;
        doors = new ArrayList<Door>();
        obstructions = new ArrayList<TestObstruction>();
    }
    
    public ArrayList<Door> getDoors() {
        return doors;
    }

    public void setDoors(ArrayList<Door> doors) {
        this.doors = doors;
    }
    
    public ArrayList<TestObstruction> getObstructions () {
        return obstructions;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
    
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void render(Graphics g) {
        g.drawImage(Assets.roomImages.get(game.getCurrentRoom()), 0, 0, getWidth(), getHeight(), null);
        //g.setColor(new Color(0,0,0));
        //g.fillRect(0, 0, game.getWidth(), game.getHeight());
        for (TestObstruction o : this.obstructions) {
            o.render(g);
        }
        for (Door d : this.doors) {
            d.render(g);
        }
    }
    
}
