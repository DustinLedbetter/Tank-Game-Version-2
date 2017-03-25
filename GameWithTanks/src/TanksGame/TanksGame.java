/*
 * Author: Dustin Ledbetter
 * Date: 3/25/2017
 * Purpose: A game for 2 players to play with tanks on one pc together.
 * This is to be updated version to my "shooter" I made several years ago. 
 * It is my way of refreshing myself with java and of making a better game.
 * This will be version 2 out of 3. 2 will be new mechanics.
 * 3 will be enhanced and added controls for tanks and better background
 * possible version 4 with multiple levels?
 */
package TanksGame;



//imports
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *Class: TanksGame
 * "extends Canvas" (allows for buffering of graphics on JFrame)
 * "implements Runnable" (allows us to not use full CPU managing FPS)
 */
public class TanksGame extends Canvas implements Runnable{

    //needed when using Canvas
    private static final long serialVersionUID = 1L;
    //sets game screen width
    private static final int WIDTH = 600;
    //sets game screen height
    private static final int HEIGHT = 600;
    //creates thread for use in 'game loop'
    private Thread thread;
    //creates buffer element from Canvas
    private BufferStrategy bs = null;
    //creates graphics element from Graphics
    private Graphics graphics = null;
    //creates toggle for starting and closing game
    private boolean running = false;
    
    
    //constructor for JFrame
    public TanksGame(){
        
        //creating our frame
        JFrame frame = new JFrame ("Tank Game");
        //setting the size of the frame
        frame.setSize(WIDTH, HEIGHT);
        //set default option to close game on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ensure game size parameters are not changed
        frame.setResizable(false);
        /* adding the canvas to frame so we can 
         * then update canvas and it will update in frame
         * throughout gameplay*/
        frame.add(this);
        //adding TanksGame to thread to use in 'game loop'
        thread = new Thread(this);
        //ensuring frame is visible
        frame.setVisible(true);
    }

    //buffer for game
    public void paint(Graphics g){
        //make sure buffer is empty at game runtime
        if(bs == null){
            //using BufferStrategy from Canvas
            createBufferStrategy(2);
            //putting it into our buffer
            bs = getBufferStrategy();
            //setting graphics
            graphics = bs.getDrawGraphics();
            //dont want to start looping til have graphics in bufferstrategy
            //will create issues if try to loop and render before graphics exist
            thread.start();
            //starts game
            running = true;
        }
    }
    
    //unfinished atm
    public void update(){
        
    }
    
    //where all game image components will be created
    public void render(){
        //ensure screen gets cleared of what was there before
        graphics.clearRect(0, 0, WIDTH, HEIGHT);
        //set screen to be black (version 3 will be better background )
        graphics.setColor(Color.black);
        //rectangle that fills game screen
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        //temp for string to ensure working how wanted it to
        graphics.setColor(Color.white);
        graphics.drawString("This is temporary", 50, 50);
    }
    
    
    
        @Override //'The game' repeat this over and over as game plays
    public void run() {
        //game loop
        while(running){
            //calls update (unfinished atm)
            update();
            //call render to draw all of game content in buffer for graphics and then show it
            render();
            //takes next buffer in list to be shown and shows it and then puts it into another
            //buffer in the background and swaps them out the next time bs.show is called
            bs.show();
            //slowing down so not full use of cpu and still smooth, but not quite 60 fps just yet. (to be continued)
            Thread.currentThread();
            try{
                //sleep for 10 milliseconds
                Thread.sleep(10);
            } catch(InterruptedException e){
                
            }
        }
    }
    
    //main
    public static void main(String[] args){
        
        //calling our game when run program
        new TanksGame();
    }

    
    
    
    
    
}