package pk_users;
import java.util.ArrayList;
import pk_refunds.Refund;
import pk_business.Booking;
public class Customer extends User {
	
	private ArrayList<Refund> refundRequests;
	private ArrayList<Booking> userBookings;
	
	public Customer(){}
	public Customer( int in_UserID , String in_username , String in_password ){
		super(in_UserID,in_username,in_password);
		refundRequests = new ArrayList<Refund>();
		userBookings = new ArrayList<Booking>();
	}
	
	public ArrayList<Refund> getRequestedRefunds(){
		return refundRequests;
	}
	
	public void addRefundRequest( Refund in_refund ){
		refundRequests.add(in_refund);
	}
	public boolean addBooking( Booking in_Booking ){
		userBookings.add(in_Booking);
		return true;
	} 
}