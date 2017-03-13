public class Seat{
	private String seatNum;
	private Customer c;
	private Seller s;
	private boolean avail;
	
	public Seat(String seatNum){
		this.seatNum = seatNum;
		avail = true;
		c = null;
		s = null;
	}
	public void setCustomer(Customer c){
		this.c = c;
	}
	public Customer getCustomer(){
		return c;
	}
	public void setSeller(Seller s){
		this.s = s;
	}
	public Seller getSeller(){
		return s;
	}
	public boolean isAvail(){
		return avail;
	}
	public void sell(){
		avail = false;
	}
	public String getSeatNum(){
		return seatNum;
	}
}