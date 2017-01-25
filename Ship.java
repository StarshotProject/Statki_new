package Game;

public class Ship {
	int numberOfMasts;
	Mast[] masts;

	Ship(int x) {
		numberOfMasts = x;
		masts = new Mast[numberOfMasts];
		for (int i = 0; i < numberOfMasts; i++) {
			masts[i] = new Mast();
		}
	}
	
	boolean isSet() {
		boolean setFlag = true;
		for (Mast m : this.masts) {
			if (m.setOnBoard == false) {
				setFlag = false;
			}
		}
		return setFlag;
	}
}