public class Customer{
	private String id;
	private Seat seat;
	public Customer(){
		id = "";
		seat = null;
		
	}
	public String getID(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public Seat getSeat(){
		return seat;
	}
	public void setSeat(Seat num){
		seat = num;
	}
}