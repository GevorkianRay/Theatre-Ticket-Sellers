import java.util.LinkedList;
import java.util.Queue;

public class Seller{
	private String ticketPrice; //H,M,L sellers
	private int id; //seller id
	private int n; //input 
	Queue<Customer> line = new LinkedList<Customer>();
	
	public Seller(String ticketPrice, int id, int n){
		this.ticketPrice = ticketPrice;
		this.id = id;
		this.n = n;
	}
	public void setPrice(String p){
		ticketPrice = p;
	}
	public String getPrice(){
		return ticketPrice;
	}
	public void setID(int id){
		this.id = id;
	}
	public int getID(){
		return id;
	}
	public void addCustomer(Customer c){
		if(line.size() < n){
			line.add(c);
		}
	}
	
}