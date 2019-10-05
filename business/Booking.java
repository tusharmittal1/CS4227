package business;

import persistance.DatabaseAccessObject;

public class Booking {
	private DatabaseAccessObject du;
	private int userId;
	private int listingId;
	private int seatId;
	private int seatNo;
	private String paymentTyp;
	
	public Booking(int userId, int listingId, int seatNo , String paymentTyp ){
		this.userId = userId;
		this.listingId = listingId;
		this.seatNo = seatNo;
		this.paymentTyp = paymentTyp;
	}
	
	public void updateDatabase() {
		du = new DatabaseAccessObject();
		du.addBooking(userId, listingId,seatNo,paymentTyp);
	}
	
	public String getInfo(){
		return "This is some information\n this is more info\n this is the last bit of info";
	}
}
