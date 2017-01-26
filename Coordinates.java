package Game;

import java.util.*;

public class Coordinates {
	 private int horizontalPosition;
	 private int verticalPosition;
	
	public static HashMap<String, Integer> letterToNumber = new HashMap<>(10);
	
	Coordinates(){
		letterToNumber.put("a", 0);
		letterToNumber.put("b", 1);
		letterToNumber.put("c", 2);
		letterToNumber.put("d", 3);
		letterToNumber.put("e", 4);
		letterToNumber.put("f", 5);
		letterToNumber.put("g", 6);
		letterToNumber.put("h", 7);
		letterToNumber.put("i", 8);
		letterToNumber.put("j", 9);
		horizontalPosition  = 11;
		verticalPosition  =11;
	}
	
	Coordinates(int horizontal, int vertical){
		horizontalPosition = horizontal;
		verticalPosition = vertical;
	}
	
	public Coordinates(int [] tab) {
		tab[0] = horizontalPosition;
		tab[1] = verticalPosition;
		letterToNumber.put("a", 0);
		letterToNumber.put("b", 1);
		letterToNumber.put("c", 2);
		letterToNumber.put("d", 3);
		letterToNumber.put("e", 4);
		letterToNumber.put("f", 5);
		letterToNumber.put("g", 6);
		letterToNumber.put("h", 7);
		letterToNumber.put("i", 8);
		letterToNumber.put("j", 9);
	}
	
	void setCoordinates(int x, int y){
		horizontalPosition = x;
		verticalPosition = y;
	}
	
	void setCoordinates(int[] tab){
		horizontalPosition = tab[0];
		verticalPosition = tab[1];
	}
	
	int [] getCoordinates(){
		int [] temp = new int[2];
		temp[0] = horizontalPosition;
		temp[1] = verticalPosition;
		return temp;	
	}
	
	public int getHorizontalPosition() {
		return horizontalPosition;
	}

	public void setHorizontalPosition(int horizontalPosition) {
		this.horizontalPosition = horizontalPosition;
	}

	public int getVerticalPosition() {
		return verticalPosition;
	}

	public void setVerticalPosition(int verticalPosition) {
		this.verticalPosition = verticalPosition;
	}	
}