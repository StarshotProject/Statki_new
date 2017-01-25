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

// void setShipOnBoard()

// metoda "umieœæ statek" powinna siê wykonaæ po dla wszystkich kolejnych
// obiektów typu statek gracza
// void umieœæ_statek(Statek ob){
// System.out.println("Podaj po³o¿enie statku 1-masztowego numer 1");
// System.out.println("Sposób podawania wspó³rzêdnych: np. A1");//sprawdzam czy
// poda³ 2 chary, jeœli tak to sprawdzam, czy pierwszy jest liter¹ z zadanego
// przedzia³u, a potem czy drugi jest liter¹ z zadanego przedzia³u, jeœli tak to
// wywo³uje metodê kontroli danych, jeœli zwraca poprawnoœæ jako true, to
// nastêpuje ustawienie statku na planszy
// //wersja alternatywna: konwertuje a->1, b->2 itp. - z³e rozwi¹zanie bo
// tracimy kontrolê wprowadzonych danych,
// //a skoro i tak musimy j¹ wykonaæ to niech gracz podaje dane w postaci
// wygodnej dla niego.
// //konwersje (a->1) nale¿y wykonaæ pod spodem,
// //metoda umieszczaj¹ca statki powinna równie¿ uruchomiæ metodê kontroli
// poprawnoœci danych.
// plansza[this.po³o¿enie[0]][this.po³o¿enie[1]]=1;
//
//
//
//
// }
//
// // przejœcie po wszystkic statkach danego gracza, zczytanie z ka¿dego
// // po³o¿enia i modyfikacja odpowiedniego pola na planszy.
// void umieœæ_wszystkie_statki(Gracz ob){
// for(Statek x: ob.statki){
// //jak uzyskaæ dostêp do wszystkich statków w kolekcji po kolei
// //poni¿sza instrukcja jest wykonywana dla ka¿dego obiektu kolekcji statki
// try{
// plansza[po³o¿enie[0]][po³o¿enie[1]]=1;
// plansza[po³o¿enie[2]][po³o¿enie[3]]=1;
// plansza[po³o¿enie[4]][po³o¿enie[5]]=1;
// plansza[po³o¿enie[6]][po³o¿enie[7]]=1;
// }
// catch (ArrayIndexOutOfBoundsException poza_po³o¿eniem) {
// continue;
// }
