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
        roomImages.add(ImageLoader.loadImage("/images/FrontYard.jpg")); //0
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //1
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //2 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //3 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/GreatHallRoom.jpeg")); //4
        roomImages.add(ImageLoader.loadImage("/images/Library.jpg")); //5
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //6 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //7 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //8 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //9 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/CandyRoom.jpg")); //10
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //11 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //12 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //13 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //14 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //15 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //16 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //17 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //18 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //19 *PLACEHOLDER*
        roomImages.add(ImageLoader.loadImage("/images/Lobby.jpg")); //20 *PLACEHOLDER*
        
        player = ImageLoader.loadImage("/images/mario.png");
        enemy = ImageLoader.loadImage("/images/fireball.png");
    }
    
}
