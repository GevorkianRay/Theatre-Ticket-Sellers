
public class HSeller extends Seller {
	public HSeller(int numCust,seats a,String sellerName,Timer timer) {
		super(numCust,a,sellerName,timer);
		max=2;
		min=1;
		row=0;
	}
	
	public void sellTicket(int min1, int max1,Customer c) {
		Timer a = new Timer();
		int currentTime=a.getTime();
		sellingTime=(int)Math.ceil((Math.random()*2));
	
		while(a.getTime()<sellingTime) {
			System.out.println("i am selling" + a.getTime()  + "\t " + sellingTime);//do nothing until it is time to sell
		}
		checkSeatMap(c);
		
	}
	
	public void checkSeatMap( Customer c ) {
	
		boolean checkingForEmptySeat = true;
		for(int ro = 0 ; checkingForEmptySeat; ro++) {
			System.out.println(ro);
			for(int co=0;checkingForEmptySeat; co++ ) {
				if(!map.isSold(ro, co)) {
					checkingForEmptySeat=false;
					map.seat[ro][co]=c.name;
					map.toString();
				}
			
			}
			}
	
		}
}
