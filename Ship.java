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

	boolean shapeControl(){
		boolean properShape = true;
		double distance;
		for(int i=0;i<this.masts.length-1;i++){
				distance = (Math.pow((this.masts[i].position.getHorizontalPosition()-this.masts[i+1].position.getHorizontalPosition()),2) +
				Math.pow((this.masts[i].position.getVerticalPosition() - this.masts[i+1].position.getVerticalPosition()), 2));
				if(distance>1){
					properShape = false;
				}
				System.out.println(distance);
		} 
		return properShape;
	}
}