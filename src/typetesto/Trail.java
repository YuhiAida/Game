package typetesto;

import java.awt.Color;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	private float alpha = 1;
	private float life;
	private Handler handler;
	private Color color;
	
	private int width, height;
	
	public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}

	public void tick() {
		if (alpha > life) {
			alpha -= life - 0.001f;
		}else handler.removeObject(this);
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTRansparent(alpha));
		
		g.setColor(color);
		g.fillRect(x, y, height, width);
		
		g2d.setComposite(makeTRansparent(1));

	}
	
	private AlphaComposite makeTRansparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}
	
	public Rectangle getBounds() {
		return null;
	}
}
