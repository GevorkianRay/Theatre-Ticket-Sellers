
public class MSeller extends Seller {
	public MSeller(int numCust, seats a,String sellerName,Timer timer) {
		super(numCust,a,sellerName,timer);
		max=4;
		min=2;
		row=5;
		
	}
	public void checkSeatMap() {
		Customer c=listOfCust.remove(0); //remove first customer on list
		boolean x = true;
		for(int ro = 5 ; x; ro++) {
			for(int co=0; x; co++ ) {
				if(map.isSold(ro, co)) {
					x=false;
					map.seat[ro][co]=c.name;
				}
			}
			}
		
		}
}
