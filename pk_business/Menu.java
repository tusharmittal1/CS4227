package pk_business;

import java.util.ArrayList;
import java.util.Date;

import pk_database.DatabaseControl;
import pk_movies.Movie;
import pk_movies.MovieListing;

public class Menu {
	private DatabaseControl du;
	private ArrayList<Movie> movies;
	private ArrayList<MovieListing> listings;
    private String selectedMovie;
    private String selectedTime;
    private Date selectedDate;
    private int movieId;
    private int listId;
    private int numberOfSeats;
    private String[] array;
    
	public String[] getMovieNames() {
		String[] names;
			du = new DatabaseControl();
			movies = du.getMovies();
			names = new String[movies.size()];
			for(int i = 0; i < movies.size(); i++) {
				names[i] = movies.get(i).getName();
			}
			return names;
	}
	
	public String getGenre(String name) {
		selectedMovie = name;
		System.out.print(selectedMovie);
		String genre = null;
		for(int i = 0; i < movies.size(); i++) {
			if(movies.get(i).getName() == selectedMovie) {
				genre = movies.get(i).getGenre();
				movieId = movies.get(i).getMovieId();
			}
		}
		return genre;
	}
	
	public Date[] getDates(String name) {
		du = new DatabaseControl();
		listings = du.getDates(name);
		ArrayList<Date> dates = new ArrayList<>();
		for(MovieListing movie : listings) {
			if(!dates.contains(movie.getDate())){
					dates.add(movie.getDate());
			}
		}
		Date[] returnDates = dates.toArray(new Date[dates.size()]);
		return returnDates;
	}
	
	public String[] getTimes(Date date) {
		selectedDate = date;
		ArrayList<String> times = new ArrayList<>();
		for(MovieListing movie : listings) {
			if((movie.getDate()).getTime() == date.getTime()) {
				times.add(movie.getTime());
			}
		}
		String[] time = times.toArray(new String[times.size()]);
		return time;
	}
	
	public String[] getSeats(String time) {
		selectedTime = time;
		String seats;
		String[] seatsArray = null;
		System.out.print("code is here 1" + selectedDate.getTime() + " " + movieId + selectedTime);
		for(MovieListing mov : listings) {
			if(((mov.getDate()).getTime() == selectedDate.getTime()) && (mov.getMovieId() == movieId) && (mov.getTime() == selectedTime) ) {
				seats = du.getSeats(mov.getListId());
				listId = mov.getListId();
				seatsArray = seats.split("-");
			}
		}
		return seatsArray;
	}
	
	public void setSeats(String[] array, int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
		this.array = array;
	}
	
	public void addBooking(String paymentType, int userId) {
		Booking newBook = new Booking(userId,listId,numberOfSeats, paymentType);
		newBook.updateDatabase();
		String seats = "";
		for(int i = 0; i < array.length - 1; i++) {
			seats += array[i] + "-";
		}
		seats += array[array.length-1];
		du.setSeats(seats);
	}
}
