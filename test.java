package Game;

import java.util.HashMap;

public class test {

//	public static void setShips(Player ob) {
//		for (int i = 0; i < 20; i++) {
//			Coordinates coordinates = readCoordinates();
//			if (ob.shipDistribution.board[coordinates.getHorizontalPosition()][coordinates
//					.getVerticalPosition()] == 0) {
//				ob.shipDistribution.board[coordinates.getHorizontalPosition()][coordinates.getVerticalPosition()] = 1;
//				ob.shipDistribution.displayBoard();
//			} else {
//				System.out.println("Tam ju¿ jest statek!:)");
//				System.out.println("Spróbuj jeszcze raz");
//				i--;
//			}
//		}
//
//		// for (Ship x : ob.ships) {
//		// for (Mast m : x.masts) {
//		// m.setOnBoardFlag = true;
//		// }
//		// }
//	}
	
	
	public static void main(String[] args) {
	
		
		System.out.println(Math.pow(3, 3));
		Player gracz = new Player();
		gracz.shipDistribution.displayBoard();
		System.out.println();
		Coordinates k = new Coordinates();
		gracz.shipDistribution.board[3][2]=9;
		gracz.shipDistribution.displayBoard();
		for(Ship statek : gracz.ships){
			statek.masts[0].set();
			for(Mast maszt : statek.masts){
				System.out.println(maszt);
				System.out.println(maszt.setOnBoard);
			}
		}
	}

}