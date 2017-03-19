

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
		
		
		public String toString() {
			for(int i = 0 ; i < seat.length;i++) {
				for(int x = 0 ;  x < seat.length;x++) {
					System.out.print(seat[i][x] + "\t");
				}
				System.out.println();
			}
			return "" ;
		}
	
		
		
		
		
		
	
	
	}
