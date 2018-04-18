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
 * @author antoniomejorado
 */
public class Player extends Item{

    private int direction;
    private int width;
    private int height;
    private Game game;
    
    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y, width, height);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void tick() {
        // moving player depending on flags
        if (game.getKeyManager().up) {
            setDirection(1);
            if(game.getKeyManager().x) {
                setY(getY() - 10);
            } else {
                setY(getY() - 16);
            }
        }
        if (game.getKeyManager().down) {
            setDirection(3);
           if(game.getKeyManager().x) {
                setY(getY() + 10);
            } else {
                setY(getY() + 16);
            }
        }
        if (game.getKeyManager().left) {
            setDirection(4);
            if(game.getKeyManager().x) {
                setX(getX() - 10);
            } else {
                setX(getX() - 16);
            }
        }
        if (game.getKeyManager().right) {
            setDirection(3);
            if(game.getKeyManager().x) {
                setX(getX() + 10);
            } else {
                setX(getX() + 16);
            }
        }
        // reset x position and y position if colision
        if (getX() + 60 >= game.getWidth()) {
            setX(game.getWidth() - 60);
        }
        else if (getX() <= -30) {
            setX(-30);
        }
        if (getY() + 80 >= game.getHeight()) {
            setY(game.getHeight() - 80);
        }
        else if (getY() <= -20) {
            setY(-20);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
        //g.setColor(new Color(250,250,250));
        //g.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}
