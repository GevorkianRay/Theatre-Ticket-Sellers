
public class LSeller extends Seller {
	
	public LSeller(int numCust,seats a, String sellerName,Timer timer) {
		super(numCust,a,sellerName,timer);
		max=7;
		min=4;
		row = 9;
		
	}
	
	public void checkSeatMap() {
		Customer c=listOfCust.remove(0); //remove first customer on list
		boolean x = true;
		for(int ro = 9 ; x; ro--) {
			for(int co=0; x; co++ ) {
				if(map.isSold(ro, co)) {
					x=false;
					map.seat[ro][co]=c.name;
					map.toString();
				}
			}
		}
	}
}
