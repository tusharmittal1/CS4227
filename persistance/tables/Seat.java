package persistance.tables;

public class Seat {
	
	private int seatNumber;
	private boolean isBooked;
	
	// Default Constructor
	public Seat(){}
	
	public Seat( int in_seatNumber , boolean in_isBooked){
		seatNumber = in_seatNumber;
		isBooked   = in_isBooked;
	}
	
	// Getters
	public int getSeatNumber() { return seatNumber; }
	public boolean isBooked()  { return isBooked;   }
	
	// Setters
	public void setSeatNumber( int in_seatNumber ){
		seatNumber = in_seatNumber;
	}
	public void setBooked ( boolean in_isBooked ){
		isBooked = in_isBooked;
	}
}
