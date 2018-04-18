/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areUThere;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author antoniomejorado
 */
public class KeyManager implements KeyListener {
    
    public boolean up;      // flag to move up the player
    public boolean down;    // flag to move down the player
    public boolean left;    // flag to move left the player
    public boolean right;   // flag to move right the player
    public boolean z;       // flag to interact with objects
    public boolean x;       // flag to run
    public boolean pause;   // flag to pause game
    public boolean space;   // flag to continue text in textbox

    private boolean keys[];  // to store all the flags for every key
    
    public KeyManager() {
        keys = new boolean[256];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // set true to every key pressed
        if (e.getKeyCode() != KeyEvent.VK_SPACE) {
            keys[e.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // set false to every key released
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[KeyEvent.VK_SPACE] = true;
        } else {
            keys[e.getKeyCode()] = false;
        }
    }
    
    /**
     * to enable or disable moves on every tick
     */
    public void tick() {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        z = keys[KeyEvent.VK_Z];
        x = keys[KeyEvent.VK_X];
        pause = keys[KeyEvent.VK_ENTER];
        space = keys[KeyEvent.VK_SPACE];
        keys[KeyEvent.VK_SPACE] = false;
    }
}