package typetesto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.Random;

import com.sun.webkit.graphics.GraphicsDecoder;

public class Player extends GameObject{

    Random r = new Random();
    Handler handler;
    
    
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }
    
    public Rectangle getBounds(){
    	return new Rectangle(x, y, 32, 32);
    }
    
    
    public void tick(){
        x += velX;
        y += velY;
        
        x = Game.clamp(x, 1, Game.WIDTH -40);
        y = Game.clamp(y, 1, Game.HEIGHT -61);
        
		handler.addObject(new Trail(x, y, ID.Trail, Color.gray, 32, 32, 0.10f, handler));

        collision();

    }
    
    private void collision(){
    	for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					//Collision code
					HUD.HEALTH -=2;
				}
			}
		}
    	
    }    
    public void render(Graphics g){
    	
		g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
    
    
    
}
