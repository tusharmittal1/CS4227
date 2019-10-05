package persistance.tables;

import java.util.Date;

public class MovieListing {
	private int listingId;
	private int movieId;
	private Date date;
	private String time;
	
	public MovieListing(int listingId, int movieId, Date date, String time){
		this.listingId = listingId;
		this.movieId = movieId;
		this.date = date;
		this.time = time;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public int getListId() {
		return listingId;
	}
	
}
