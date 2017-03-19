public class LSeller extends Seller {
	
	public LSeller(int numCust,seats a, String sellerName,Timer timer) {
		super(numCust,a,sellerName,timer);
		max=7;
		min=4;
		row = 9;
		
	}
	public void sellTicket(int min1, int max1,Customer c) {
		Timer a = new Timer();
		int currentTime=a.getTime();
		sellingTime=(int)(Math.random()*4 + 4);
		System.out.println(name + " takes " + sellingTime + " mins");
		while(a.getTime()<sellingTime) {
			//System.out.println("i am selling" + a.getTime()  + "\t " + sellingTime);//do nothing until it is time to sell
		}
		checkSeatMap(c);
		
	}
	
	public void checkSeatMap(Customer cust) {
		Customer c=listOfCust.remove(0); //remove first customer on list
		boolean x = true;
		for(int ro = 9 ;ro > 0 && x; ro--) {
			for(int co=0; co < 10 && x; co++ ) {
				if(!map.isSold(ro, co)) {
					x=false;
					map.seat[ro][co]=c.name;
					try {
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                Thread.currentThread().interrupt();
		            }
					map.toString();
				}
			}
			
		
		}
	}

}