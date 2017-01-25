package Game;

import java.util.*;

public class Game {
	static boolean theGameIsOn = true;
	static boolean player1IsActive = true;
	public static void main(String[] args) {

		Scanner skaner = new Scanner(System.in);

		Player player1 = new Player();
		Player player2 = new Player();

		System.out.println("Witaj! To jest gra 'Statki'");
		System.out.println("Poni¿ej znajduje siê twoja plansza");
		System.out.println();
		Board plansza = new Board();
		plansza.displayBoard();
		System.out.println();
		System.out.println("Masz nastêpuj¹ce statki do ustawienia na planszy");
		System.out.println("(*)(*)(*)(*) - 4 jednomasztowce");
		System.out.println("(**)(**)(**)- 3 dwumasztowce");
		System.out.println("(***)(***) - 2 trójmasztowce");
		System.out.println("(****) - 1 czteromasztowiec");
		System.out.println("Aby umieœciæ statek na planszy, podaj wspó³rzêdne");
		System.out.println("Podawaj wspó³rzedne pokolei w postaci np.'a1'");
		
		GameEngine.setShips(player1);
		System.out.println();
		GameEngine.setShipsAutomatically(player2);
		
		System.out.println();
		System.out.println("Statki ustawione, zaczynamy grê! :)");
		Help.helpDisplay();
		
		int TourNumber=0;
		
		while(theGameIsOn){
			System.out.print("Numer tury :");
			System.out.println(TourNumber++);
			while(player1IsActive){
				GameEngine.readDecision(player1, player2);	
			}
		GameEngine.shootTheOpponentAutomatically(player2, player1);
		GameEngine.whoIsTheWinner(player1, player2);
		}
	}
}
