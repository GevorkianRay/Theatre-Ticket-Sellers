

public class seats {
	
	String[][] seat;
	
	/*
	 * makes 2D array of seats
	 */
	public seats() {
		seat = new String[10][10];
		for(int row= 0 ; row< seat.length; row++) {
			for(int col=0; col<seat.length;col++) {
				seat[row][col]="O";
			}
		}		
	}
/*
 * Checks if current seat is open
 */
		public boolean isSold(int x , int y) {
			if("O".compareTo(seat[x][y])==0) {
				return false;
			}
			return true;
		}
		
