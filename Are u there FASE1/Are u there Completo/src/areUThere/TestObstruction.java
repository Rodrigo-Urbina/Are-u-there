/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areUThere;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.lang.Math;
import java.util.ArrayList;

/**
 *
 * @author davidacevedo
 */
public class TestObstruction extends Item {
    
    TextBox textBox;
    Rectangle interactionBox;
    Game game;
    Color color;

    public TestObstruction(int x, int y, int width, int height, ArrayList<String> text, Game game) {
        super(x, y, width, height);
        this.game = game;
        this.textBox = new TextBox(text, game);
        this.color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }
    
    public void interacts (Player p, Graphics g) {
        if (this.intersects(p, true) && game.getKeyManager().space) {
            textBox.render(g);
            game.setInteracting(true);
            game.setCurrentInteraction(this);
        }
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void render(Graphics g) {
            g.setColor(color);
            g.fillRect(this.x, this.y, this.getWidth(), this.getHeight());
    }
}
