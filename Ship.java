package Game;

public class Ship {
	Mast[] masts;

	Ship(int x) {
		masts = new Mast[x];
		for (int i = 0; i < masts.length; i++) {
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

	boolean shapeControl(Player ob) {
		boolean properShape = true;
		for (Mast mast : this.masts) {// badam wszystkie maszty statku dla
										// którego wywo³a³em ta metode
			try {
				if (ob.shipDistribution.board[mast.position.getVerticalPosition() - 1][mast.position
						.getHorizontalPosition()] == 1
						|| ob.shipDistribution.board[mast.position.getVerticalPosition()][mast.position
								.getHorizontalPosition() - 1] == 1
						|| ob.shipDistribution.board[mast.position.getVerticalPosition()][mast.position
								.getHorizontalPosition() + 1] == 1
						|| ob.shipDistribution.board[mast.position.getVerticalPosition() + 1][mast.position
								.getHorizontalPosition()] == 1) {
					properShape = true;
				} else {
					properShape = false;
				}
			} catch (ArrayIndexOutOfBoundsException aioobe) {
			}
		}
		return properShape;
	}

	// boolean properShape = true;
	// double distance;
	// for(int i=0;i<this.masts.length-1;i++){
	// distance =
	// (Math.pow((this.masts[i].position.getHorizontalPosition()-this.masts[i+1].position.getHorizontalPosition()),2)
	// +
	// Math.pow((this.masts[i].position.getVerticalPosition() -
	// this.masts[i+1].position.getVerticalPosition()), 2));
	// if(distance>1){
	// properShape = false;
	// }
	// System.out.println(this.masts[i].position.getHorizontalPosition());
	// System.out.println("dystans: "+distance);
	// System.out.println("mast[i] horizontal
	// "+this.masts[i].position.getHorizontalPosition());
	// System.out.println("mast[i+1] horizontal "+
	// this.masts[i+1].position.getHorizontalPosition());
	// System.out.println("mast[i] vertical
	// "+this.masts[i].position.getVerticalPosition());
	// System.out.println("mast[i+1] vertical
	// "+this.masts[i+1].position.getVerticalPosition());
	// }
	// return properShape;

}