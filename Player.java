package Game;

import java.util.ArrayList;

public class Player {

	Board shipDistribution;
	Board previousShotsDistribution;
	private int hitCounter;

	void incrementHitCounter() {
		hitCounter++;
	}

	public int getHitCounter() {
		return hitCounter;
	}

	private boolean isWinner = false;

	boolean getIsWinner() {
		return isWinner;
	}

	Ship ship1a = new Ship(1);
	Ship ship1b = new Ship(1);
	Ship ship1c = new Ship(1);
	Ship ship1d = new Ship(1);
	Ship ship2a = new Ship(2);
	Ship ship2b = new Ship(2);
	Ship ship2c = new Ship(2);
	Ship ship3a = new Ship(3);
	Ship ship3b = new Ship(3);
	Ship ship4a = new Ship(4);
	Ship[] ships = { ship1a, ship1b, ship1c, ship1d, ship2a, ship2b, ship2c, ship3a, ship3b, ship4a };

	Player() {
		shipDistribution = new Board();
		previousShotsDistribution = new Board();

		ship1a = new Ship(1);
		ship1b = new Ship(1);
		ship1c = new Ship(1);
		ship1d = new Ship(1);
		ship2a = new Ship(2);
		ship2b = new Ship(2);
		ship2c = new Ship(2);
		ship3a = new Ship(3);
		ship3b = new Ship(3);
		ship4a = new Ship(4);
	}

	void outlineShips() {
		for (Ship ship : this.ships) {
			for (Mast mast : ship.masts) {
				if (mast.setOnBoard = true) {
					System.out.println("Nowy przebieg");
					System.out.println(mast.toString());
					System.out.println(mast.setOnBoard);
					try {
						if (this.shipDistribution.board[mast.position.getVerticalPosition() - 1][mast.position
								.getHorizontalPosition() - 1] == 0) {
							this.shipDistribution.board[mast.position.getVerticalPosition() - 1][mast.position
									.getHorizontalPosition() - 1] = 3;
							System.out.println("1");
						}
					} catch (ArrayIndexOutOfBoundsException aiobe) {
					}
					try {
						if (this.shipDistribution.board[mast.position.getVerticalPosition()-1][mast.position
								.getHorizontalPosition()] == 0) {
							this.shipDistribution.board[mast.position.getVerticalPosition()-1][mast.position
									.getHorizontalPosition()] = 3;
							System.out.println("2");
						}
					} catch (ArrayIndexOutOfBoundsException aiobe) {
					}
					try {
						if (this.shipDistribution.board[mast.position.getVerticalPosition() - 1][mast.position
								.getHorizontalPosition() + 1] == 0) {
							this.shipDistribution.board[mast.position.getVerticalPosition() - 1][mast.position
									.getHorizontalPosition() + 1] = 3;
							System.out.println("3");
							System.out.println(
									mast.position.getVerticalPosition() + "x" + mast.position.getHorizontalPosition());

						}
					} catch (ArrayIndexOutOfBoundsException aiobe) {
					}
					try {
						if (this.shipDistribution.board[mast.position.getVerticalPosition() ][mast.position
								.getHorizontalPosition()+1] == 0) {
							this.shipDistribution.board[mast.position.getVerticalPosition() ][mast.position
									.getHorizontalPosition()+1] = 3;
							System.out.println("4");
						}
					} catch (ArrayIndexOutOfBoundsException aiobe) {
					}
					try {
						if (this.shipDistribution.board[mast.position.getVerticalPosition() + 1][mast.position
								.getHorizontalPosition() + 1] == 0) {
							this.shipDistribution.board[mast.position.getVerticalPosition() + 1][mast.position
									.getHorizontalPosition() + 1] = 3;
							System.out.println("5");
						}
					} catch (ArrayIndexOutOfBoundsException aiobe) {
					}
					try {
						if (this.shipDistribution.board[mast.position.getVerticalPosition()+1][mast.position
								.getHorizontalPosition() ] == 0) {
							this.shipDistribution.board[mast.position.getVerticalPosition()+1][mast.position
									.getHorizontalPosition()] = 3;
							System.out.println("6");
						}
					} catch (ArrayIndexOutOfBoundsException aiobe) {
					}
					try {
						if (this.shipDistribution.board[mast.position.getVerticalPosition() + 1][mast.position
								.getHorizontalPosition() - 1] == 0) {
							this.shipDistribution.board[mast.position.getVerticalPosition() + 1][mast.position
									.getHorizontalPosition() - 1] = 3;
							System.out.println("7");
						}
					} catch (ArrayIndexOutOfBoundsException aiobe) {
					}
					try {
						if (this.shipDistribution.board[mast.position.getVerticalPosition() ][mast.position
								.getHorizontalPosition()-1] == 0) {
							this.shipDistribution.board[mast.position.getVerticalPosition()][mast.position
									.getHorizontalPosition()-1] = 3;
							System.out.println("8");
						}
					} catch (ArrayIndexOutOfBoundsException aiobe) {
					}
				}
			}
		}
	}
}
