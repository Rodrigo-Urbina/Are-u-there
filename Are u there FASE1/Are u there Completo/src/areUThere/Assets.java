/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areUThere;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author antoniomejorado
 */
public class Assets {
    
    public static ArrayList<BufferedImage> roomImages;      // to store the backgrounds of the rooms
    public static BufferedImage player;                     // to store the player image
    public static BufferedImage enemy;                      // to store the enemy image

    /**
     * initializing the images of the game
     */
    public static void init() {
        
        roomImages = new ArrayList<>();
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg"));
        roomImages.add(ImageLoader.loadImage("/images/Library.jpg"));
        roomImages.add(ImageLoader.loadImage("/images/FrontYard.jpg"));
        roomImages.add(ImageLoader.loadImage("/images/CandyRoom.jpg"));
        
        player = ImageLoader.loadImage("/images/mario.png");
        enemy = ImageLoader.loadImage("/images/fireball.png");
    }
    
}
