/*
@author David Acevedo Villarreal
        A01196678
@author Rodrigo Enrique Urbina De la Cruz
        A01281933
 */
package areUThere;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author antoniomejorado
 */
public class Game implements Runnable {

    private BufferStrategy bs;                          // to have several buffers when displaying
    private Graphics g;                                 // to paint objects
    private Display display;                            // to display in the game
    String title;                                       // title of the window
    private int width;                                  // width of the window
    private int height;                                 // height of the window
    private Thread thread;                              // thread to create the game
    private boolean running;                            // to set the game
    private KeyManager keyManager;                      // to manage the keyboard
    private Player player;                              // to use a player
    private ArrayList<Room> rooms;                      // to store rooms
    private int currentRoom;                            // to save current room
    private Enemy enemy;                                // to use a enemy
    private boolean interacting;                         // to determine intersections
    private TestObstruction currentInteraction;         // to determine which textbox to display on collision
    int changeRoomFrameCount;       
    boolean changingRoom;
    int changingRoomAlpha;
    Door tempDoor;
    Door selectedDoor;
    int changingRoomAux;
    
    


    /**
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        keyManager = new KeyManager();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
     
    /**
     * To get the width of the game window
     *
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }

    public boolean isInteracting() {
        return interacting;
    }

    public void setInteracting(boolean interacting) {
        this.interacting = interacting;
    }

    public TestObstruction getCurrentInteraction() {
        return currentInteraction;
    }

    public void setCurrentInteraction(TestObstruction currentInteraction) {
        this.currentInteraction = currentInteraction;
    }

    /**
     * To get the height of the game window
     *
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public Player getPlayer() {
        return player;
    }
    
    /**
     * initializing the display window of the game
     */
    private void init() {
        display = new Display(title, getWidth(), getHeight());
        Assets.init();
        player = new Player(0, getHeight() - 100, 1, 64, 96, this);
        rooms = new ArrayList<Room>();
        currentRoom = 0;
        interacting = false;
        enemy = new Enemy(300, 110, 50, 50, this);
        display.getJframe().addKeyListener(keyManager);
        currentRoom = 3;
        changingRoom = false;
        interacting = false;
        changingRoomAlpha = 1;
        changingRoomAux = 1;
        
        
        //--------------ROOMS------------------
        //Falta corregir las conexiones.
        ArrayList<String> temp; 
        
        //Lobby
        rooms.add(new Room(1024,768, this));
        rooms.get(0).getDoors().add(new Door(0, 436, 16, 64, 1, 0, 0));
        rooms.get(0).getDoors().add(new Door(1008, 436, 16, 64, 2, 0, 0));
        rooms.get(0).getDoors().add(new Door(448, 240, 128, 96, 3, 0, 0));
        rooms.get(0).getDoors().add(new Door(448, 576, 128, 16, 3, 0, 0));
        temp = new ArrayList<String>();
        temp.add("Sofa");
        rooms.get(0).getObstructions().add(new TestObstruction(96,304,256,96,temp,this));
        rooms.get(0).getObstructions().add(new TestObstruction(672,304,256,96,temp,this));
        
        //Library
        rooms.add(new Room(1024,1536, this));
        rooms.get(1).getDoors().add(new Door(0,700,16,64, 0, 0, 0));
        temp = new ArrayList<String>();
        temp.add("Reading table");
        rooms.get(1).getObstructions().add(new TestObstruction(320,640,384,128,temp,this));
        temp = new ArrayList<String>();
        temp.add("Chair");
        rooms.get(1).getObstructions().add(new TestObstruction(272,640,48,112,temp,this));
        rooms.get(1).getObstructions().add(new TestObstruction(704,640,48,112,temp,this));
        
        //FrontYard
        rooms.add(new Room(1024,1536, this));
        rooms.get(2).getDoors().add(new Door(448, 240, 128, 160, 0, 0, 0));
        //temp = new ArrayList<String>();
        //rooms.get(2).getObstructions().add(new TestObstruction(0,0,100,100,temp,this));
        
        //CandyRoom
        rooms.add(new Room(1024,768, this));
        rooms.get(3).getDoors().add(new Door(320, 384, 16, 64, 0, 0, 0));
        temp = new ArrayList<String>();
        temp.add("Candy racks");
        rooms.get(3).getObstructions().add(new TestObstruction(320,192,112,160,temp,this));
        rooms.get(3).getObstructions().add(new TestObstruction(464,192,96,160,temp,this));
        rooms.get(3).getObstructions().add(new TestObstruction(592,192,112,160,temp,this));
        temp = new ArrayList<String>();
        temp.add("Gum machine");
        rooms.get(3).getObstructions().add(new TestObstruction(352,448,96,128,temp,this));
        temp = new ArrayList<String>();
        temp.add("Cotton candy");
        rooms.get(3).getObstructions().add(new TestObstruction(576,448,128,128,temp,this));
        
    }

    @Override
    public void run() {
        init();
        // frames per second
        int fps = 24;
        // time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        // initializing delta
        double delta = 0;
        // define now to use inside the loop
        long now;
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running) {
            // setting the time now to the actual time
            now = System.nanoTime();
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            // updating the last time
            lastTime = now;

            // if delta is positive we tick the game
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }
        stop();
    }

    private void tick() {
        keyManager.tick();
        if (interacting) {
            currentInteraction.textBox.tick();
        } else if (changingRoom) {
            if (changingRoomAlpha >= 255) {
                changingRoomAlpha = 254;
                currentRoom = 1;
                selectedDoor = null;
                changingRoomAux = -1;
            } else if (changingRoomAlpha <= 0) {
                changingRoom = false;
                changingRoomAlpha = 1;
                changingRoomAux = 1;
            } else {
               changingRoomAlpha += (5 * changingRoomAux);
            }
        } else {
            player.tick();
            enemy.tick();
            
            for(TestObstruction o: rooms.get(currentRoom).getObstructions()) {
                o.interacts(player, g);
                if(player.intersects(o)) {
                    if (player.getDirection() == 1) {
                        player.setY(player.getY() + 32);
                    } else if (player.getDirection() == 2) {
                        player.setX(player.getX() - 32);
                    } else if (player.getDirection() == 3) {
                        player.setY(player.getY() - 32);
                    } else if (player.getDirection() == 4) {
                        player.setX(player.getX() + 32);
                    }
                }
                
                if(enemy.intersects(o)) {
                    if (enemy.getDirection() == 1) {
                        enemy.setY(enemy.getY() + 32);
                    } else if (enemy.getDirection() == 2) {
                        enemy.setX(enemy.getX() - 32);
                    } else if (enemy.getDirection() == 3) {
                        enemy.setY(enemy.getY() - 32);
                    } else if (player.getDirection() == 4) {
                        enemy.setX(enemy.getX() + 32);
                    }
                }
            }
            for (Door d : rooms.get(currentRoom).getDoors()) {
                if (d.intersects(player)) { //esto esta aqui para checar si el jugador cruza una puerta 
                    selectedDoor = d;
                    changingRoom = true;
                    player.setX(this.getWidth() / 2);
                    player.setY(this.getHeight() / 2);
                }
            } 
        }
    }

    private void render() {
        // get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display every image of the game but
        after clearing the Rectanlge, getting the graphic object from the 
        buffer strategy element. 
        show the graphic and dispose it to the trash system
         */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            rooms.get(currentRoom).render(g);
            player.render(g);
            enemy.render(g);
            if(interacting) {
                currentInteraction.textBox.render(g);
            } else if (changingRoom) {
                if (changingRoomAlpha > 255) {
                    changingRoomAlpha = 255;
                } else if (changingRoomAlpha < 0) {
                    changingRoomAlpha = 0;
                }
                System.out.println(changingRoomAlpha);
                g.setColor(new Color(0,0,0,changingRoomAlpha));
                g.fillRect(0,0,getWidth(), getHeight());
            }
            bs.show();
            g.dispose();
        }
    }
    
    /**
     * setting the thread for the game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * stopping the thread
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
