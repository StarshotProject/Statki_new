package Game;

public class Board {

	int boardSize = 10;

	int[][] board;
	char[] horizontalCoordinates = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
	int[] verticalCoordinates = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	Board() {
		board = new int[boardSize][boardSize];
	}

	void displayBoard() {
		System.out.print("  ");

		for (int i = 0; i < boardSize; i++) {
			System.out.print(horizontalCoordinates[i] + " ");
		}
		for (int i = 0; i < boardSize; i++) {// plansza
			System.out.println();
			System.out.print(verticalCoordinates[i] + " ");
			for (int j = 0; j < boardSize; j++) {
				// if(j==9)System.out.print(board[i][j] + " ");
				System.out.print(board[i][j] + " ");
			}
		}
	}

	void setValueInPosition(Coordinates coordinates, int value) {
		this.board[coordinates.getVerticalPosition()][coordinates.getHorizontalPosition()] = value;
		this.board[coordinates.getHorizontalPosition()][coordinates.getHorizontalPosition()] = value;
	}
}