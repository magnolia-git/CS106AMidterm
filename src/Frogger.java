import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.event.MouseEvent;

public class Frogger extends GraphicsProgram {
	
	// Final variables:
	private static final int SQSIZE = 75;
	private static final int NCOLS = 7;
	private static final int NROWS = 3;
	public static final int APPLICATION_WIDTH = NCOLS * SQSIZE;
	public static final int APPLICATION_HEIGHT = NROWS * SQSIZE;
	// Instance variables: 
	private static int fX = 3;
	private static int fY = 2;
	private static GImage frog = new GImage("frog.gif", SQSIZE * fX, SQSIZE * fY);
	
	public void run() {
		add(frog);
		println(frog.getX() + SQSIZE / 2);
		addMouseListeners();
	}
	
	/* Methods getXLocation and getYLocation get the center of the frog image.
	 * Any GImage can be passed through, but results may vary.
	 */
	
	private double getXLocation(GImage image) {
		return image.getX() + SQSIZE / 2;
	}
	private double getYLocation(GImage image) {
		return image.getY() + SQSIZE / 2;
	}
	
	/* The following 4 methods do as they say, with some checks on the frog's 
	 * current location.
	 */
	
	private void jumpNorth() {
		if (fY > 0) {
			frog.move(0, -SQSIZE);
			fY--;
		}
	}
	private void jumpSouth() {
		if (fY < NROWS - 1) {
			frog.move(0, SQSIZE);
			fY++;
		}
	}
	private void jumpEast() {
		if (fX < NCOLS - 1) {
			frog.move(SQSIZE, 0);
			fX++;
		}
	}
	private void jumpWest() {
		if (fX > 0) {
			frog.move(-SQSIZE, 0);
			fX--;
		}
	}
	public void mouseClicked(MouseEvent e) {
		double mouseX = e.getX();
		double mouseY = e.getY();
		
		// If the mouse is clicking in the area of the grid...
		if (mouseX <= SQSIZE * NCOLS && mouseY <= SQSIZE * NROWS) {
			// If the X position of the mouse if greater than the Y position...
			if (Math.abs(mouseX - getXLocation(frog)) > Math.abs(mouseY - getYLocation(frog))) {
				// If the X position of the mouse is greater (farther east) than the frog's...
				if (mouseX > getXLocation(frog)) jumpEast();
				else jumpWest();
			} else {
				// If the Y position of the mouse is greater (farther south) than the frog's...
				if (mouseY > getYLocation(frog)) jumpSouth();
				else jumpNorth();
			}
		}
	}
}