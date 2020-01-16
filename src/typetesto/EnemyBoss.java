package typetesto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBoss extends GameObject{

	private Handler handler;
	
	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 2;
	}
	
	public Rectangle getBounds(){
    	return new Rectangle((int)x, (int)y, 16, 16);
    }

	public void tick() {
		x += velX;
		y += velY;
		
		/*if (y <= 0 || y >= Game.HEIGHT -32) {
			velY *= -1;
		}
		if (x <= 0 || x >= Game.WIDTH -16) {
			velX *= -1;
		}*/
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.ORANGE, 96, 96, 0.04f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
