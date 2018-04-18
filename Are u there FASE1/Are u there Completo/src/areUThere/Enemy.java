/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areUThere;

import java.awt.Graphics;
import java.lang.Math;

/**
 *
 * @author Rodrigo
 */
public class Enemy extends Item{

    private Game game;
    private int hyp;
    private int xDelta;
    private int yDelta;
    private int speed;
    private int direction;
    
    public Enemy(int x, int y, int width, int height, Game game) {
        super(x, y, width, height);
        this.hyp = 0;
        this.xDelta = 0;
        this.yDelta = 0;
        this.speed = 3;
        this.game = game;
    }

    public int getDirection() {
        return direction;
    }

    @Override
    public void tick() {
        hyp = (int) Math.ceil(Math.sqrt(Math.pow(game.getPlayer().getX() - this.getX(),2) + Math.pow(game.getPlayer().getY() - this.getY(),2)));
        
        if (game.getPlayer().getX() - getX() > 0) {
            xDelta = (int) Math.ceil(this.speed * (game.getPlayer().getX() - getX())/hyp);
        } else {
            xDelta = (int) Math.floor(speed * (game.getPlayer().getX() - getX())/hyp);
        }
        
        if (game.getPlayer().getY() - getY() > 0) {
            yDelta = (int) Math.ceil(speed * (game.getPlayer().getY() - getY())/hyp);
        } else {
            yDelta = (int) Math.floor(speed * (game.getPlayer().getY() - getY())/hyp);
        }
        
        if(xDelta > yDelta) {
            if(xDelta > 0) {
                direction = 2;
            }
            else {
                direction = 4;
            }
        }
        else{
            if(yDelta < 0) {
                direction = 1;
            }
            else {
                direction = 3;
            }
        }
        
        setX(getX() + xDelta);
        setY(getY() + yDelta);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.enemy, getX(), getY(), getWidth(), getHeight(), null);
    }
}
