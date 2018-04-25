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
public class Wall extends Item {

    public Wall(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(0,255,0));
        g.fillRect(this.x, this.y, this.getWidth(), this.getHeight());
    }
    
}
