
import java.awt.geom.Rectangle2D;
import processing.core.PApplet;
import processing.core.PImage;

/*
 * Represents a moving image.
 *
 * by: Shelby
 */
 
public class Sprite extends Rectangle2D.Double {
	
	// FIELDS
	private PImage image;
	private double vx, vy;
	
	// CONSTRUCTORS
	public Sprite(PImage img, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
		vx = 0;
		vy = 0;
	}
	
	public double getVX() {
		return vx;
	}
	public double getVY() {
		return vy;
	}
	// METHODS
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	public void moveByVelocities() {
		super.x += vx;
		super.y += vy;
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}
	
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	
	public void draw(PApplet g) {
		g.image(image,(int)x,(int)y,(int)width,(int)height);
	}
	
	
}










