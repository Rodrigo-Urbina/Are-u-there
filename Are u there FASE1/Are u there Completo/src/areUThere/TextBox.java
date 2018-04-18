/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areUThere;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author davidacevedo
 */
public class TextBox {
    ArrayList<String> text;
    int x;
    int y;
    int width;
    int height;
    int currentText;
    Game game;
    
    TextBox (ArrayList<String> text, Game game) {
        this.text = text;
        this.game = game;
        this.currentText = 0;
        this.x = 50;
        this.width = game.getWidth() - 100;
        this.y = game.getHeight() - 300;
        this.height = 300;
    }
    
    public void tick() {
        if (game.getKeyManager().space) {
            System.out.println(currentText);
            currentText++;
        }
        if (currentText >= text.size()) {
            currentText = 0;
            game.setInteracting(false);
            game.setCurrentInteraction(null);
        }
    }
    
    public void render(Graphics g) {
        g.setColor(new Color(200,200,200,200));
        g.fillRect(this.x, this.y, this.width, this.height);
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        g.drawString(text.get(currentText), this.x, this.y + this.height/2);
    }
}
