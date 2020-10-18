import stanford.karel.*;
public class KarelBeeperBorder extends SuperKarel {
	
	public void run() {
		move();
		turnLeft();
		move();
		turnRight();
		move();
		makeWalls();
	}
	public void makeWalls() {
		println(7 < 9 - 5 && 3 % 0 == 3);
		if (beepersPresent()) {
			println("Okay I'm done.");
		} else {
			makeRow();
			makeWalls();
		}
	}
	public void makeRow() {
		while (frontIsClear()) {
			putBeeper();
			move();
		}
		turnAround();
		move();
		turnRight();
		move();
	}
}