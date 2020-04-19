import java.awt.*;
import java.util.*;

import processing.core.PImage;

public class Mario extends Sprite {

	public static final int MARIO_WIDTH = 40;
	public static final int MARIO_HEIGHT = 60;
	private boolean canWalkRight;
	private boolean canWalkLeft;
	private boolean isonplat;
	public Mario(PImage img, int x, int y) {
		super(img, x, y, MARIO_WIDTH, MARIO_HEIGHT);
		canWalkRight = true;
		canWalkLeft = true;
	}

	// METHODS
	/**
	 * This method should, in some way, cause Mario to move left or right. A basic version might directly
	 * move Mario, while a more advanced version might try to accelerate him using Sprite velocities.
	 * 
	 * @param dir This will be a positive 1 to indicate walking to the right, or a -1 to indicate left.
	 */
	public void walk(int dir) {
		canWalkLeft = true;
		canWalkRight = true;
		setVelocity(5 * dir, 0);
		moveByVelocities();
	}

	/**
	 * This method should, in some way, cause Mario to move upward. A basic version might just directly move him up.
	 * A more advanced version would try to use velocities to give a jump that feels right, and to only allow
	 * jumping when Mario is touching the ground.
	 */
	public void jump() {
		canWalkLeft = true;
		canWalkRight = true;
		setVelocity(0, -10); 
		moveByVelocities();
	}

	/**
	 * This method should cause Mario to do everything he does whether keys are pressed or not. Though this
	 * could be lots of things, it should at least be:
	 * - Falling downward
	 * - Colliding with obstacles such as platforms
	 * 
	 * @param obstacles A list of obstacles in the window that Mario should not be able to intersect with.
	 */
	public boolean getCanWalkRight() {
		return canWalkRight;
	}
	public boolean getCanWalkLeft() {
		return canWalkLeft;
	}
	public boolean getAct() {
		
		return isonplat;
	}
	public void act(ArrayList<Shape> obstacles) {
		// FALL (and stop when a platform is hit)
		if(obstacles.get(0).intersects(this) || obstacles.get(1).intersects(this) || 
		obstacles.get(2).intersects(this) || obstacles.get(3).intersects(this) || obstacles.get(4).
		intersects(this)) {
			
			
			setVelocity(0, 0);
			moveByVelocities();
			
				if(x == 375 && y <= 400 && y >= 300) {
					//System.out.println("f");
					setVelocity(0, 0);
					canWalkLeft = true;
					canWalkRight = false;
				}
				if(x == 425 && y <= 400 && y >= 300) {
					//System.out.println("s");
					setVelocity(0, 0);
					canWalkLeft = false;
					canWalkRight = true;

			}
				
				if(x >= 300 && x <=500 && y <= 300 && y >= 250) {
					//System.out.println("s");
					setVelocity(0, 13);
					moveByVelocities();
					canWalkLeft = false;
					canWalkRight = false;

			}
			
				isonplat =  true;
		}
		
		else {
			canWalkLeft = true;
			canWalkRight = true;
			setVelocity(0, 6);
			moveByVelocities();
			isonplat =  false;
		}
		

		
		
		// Note that there are some useful methods already in the Java library for detecting basic
		// rectangular intersection. Try this:
		// System.out.println(obstacles.get(0).intersects(this));
	}


}
