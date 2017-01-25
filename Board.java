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

// metoda "umie�� statek" powinna si� wykona� po dla wszystkich kolejnych
// obiekt�w typu statek gracza
// void umie��_statek(Statek ob){
// System.out.println("Podaj po�o�enie statku 1-masztowego numer 1");
// System.out.println("Spos�b podawania wsp�rz�dnych: np. A1");//sprawdzam czy
// poda� 2 chary, je�li tak to sprawdzam, czy pierwszy jest liter� z zadanego
// przedzia�u, a potem czy drugi jest liter� z zadanego przedzia�u, je�li tak to
// wywo�uje metod� kontroli danych, je�li zwraca poprawno�� jako true, to
// nast�puje ustawienie statku na planszy
// //wersja alternatywna: konwertuje a->1, b->2 itp. - z�e rozwi�zanie bo
// tracimy kontrol� wprowadzonych danych,
// //a skoro i tak musimy j� wykona� to niech gracz podaje dane w postaci
// wygodnej dla niego.
// //konwersje (a->1) nale�y wykona� pod spodem,
// //metoda umieszczaj�ca statki powinna r�wnie� uruchomi� metod� kontroli
// poprawno�ci danych.
// plansza[this.po�o�enie[0]][this.po�o�enie[1]]=1;
//
//
//
//
// }
//
// // przej�cie po wszystkic statkach danego gracza, zczytanie z ka�dego
// // po�o�enia i modyfikacja odpowiedniego pola na planszy.
// void umie��_wszystkie_statki(Gracz ob){
// for(Statek x: ob.statki){
// //jak uzyska� dost�p do wszystkich statk�w w kolekcji po kolei
// //poni�sza instrukcja jest wykonywana dla ka�dego obiektu kolekcji statki
// try{
// plansza[po�o�enie[0]][po�o�enie[1]]=1;
// plansza[po�o�enie[2]][po�o�enie[3]]=1;
// plansza[po�o�enie[4]][po�o�enie[5]]=1;
// plansza[po�o�enie[6]][po�o�enie[7]]=1;
// }
// catch (ArrayIndexOutOfBoundsException poza_po�o�eniem) {
// continue;
// }
