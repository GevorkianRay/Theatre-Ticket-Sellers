public class Customer implements Comparable<Customer> {
	int arrivalT;
	public Customer(int t) {
		arrivalT=t;
	}
	public int compareTo(Customer arg0) {
		// TODO Auto-generated method stub
		if(this.arrivalT>arg0.arrivalT)  {
			return 1;
		}else if (this.arrivalT<arg0.arrivalT) { 
		return -1;
		} else {
			return 0;
		}
	}	
	
}