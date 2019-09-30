package pk_users;
import java.util.ArrayList;
import pk_refunds.Refund;

public class Manager extends User{
	
	private ArrayList<Refund> refundRequests;
	
	public Manager(){}
	public Manager( int in_userID , String in_username, String in_password){
		super(in_userID,in_username,in_password);
		refundRequests = new ArrayList<Refund>();
	}
	
	public ArrayList<Refund> showRefundRequests(){
		return refundRequests;
	}
	
	public Refund approveRefundRequest( Refund in_refund ){
		
		//in_refund.setStatus("Approve");
		
		return in_refund;
	}
}