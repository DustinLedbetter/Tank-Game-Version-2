/*
 * Copyright (C) 2017 PC
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */



/*
 * Author: Dustin Ledbetter
 * Date: 3/25/2017-5/19/2017
 * Purpose: A game for 2 players to play with tanks on one pc together.
 * This is the updated version to my "shooter" I made several years ago. 
 * It is my way of refreshing myself with java and of making a better game.
 * This will be version 2 out of 3. 2 will be new mechanics.
 * 3 will be enhanced and added controls for tanks and better background
 * possible version 4 with multiple levels?
 * Class: This file is used to load images into game through a cache
 */
package TanksGame;

//imports
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class BasicCache {
    
    //variables
    private static final String IMAGE_DIR = "images";
    public static Image player1;
    public static Image player2;
    public static Image bullet;

    
    
    public BasicCache(){
        load();//loads all cache, but can later break up to load sounds,images, etc 
    }
    
    
    
    //used to load in images from IMAGE_DIR
    public void load(){
        BasicCache.player1 = loadImage("player1.png");
        BasicCache.player2 = loadImage("player2.png");
        BasicCache.bullet = loadImage("bullet.png");
    }
    
    
    
    //used to find the images in IMAGE_DIR
    private Image loadImage(String img){
        try {
           return ImageIO.read(getClass().getResource("/"+IMAGE_DIR+"/"+img));
           //return ImageIO.read(new File(IMAGE_DIR + img));
        } catch (IOException ex) {
            Logger.getLogger(BasicCache.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    
}//end line
