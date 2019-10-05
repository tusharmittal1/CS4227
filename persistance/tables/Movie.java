package persistance.tables;

public class Movie {
	
	private int movieId;
	private String name;
	private String genre;
	
	public Movie ( int movieId , String name , String genre){
		this.movieId = movieId;
		this.name = name;
		this.genre = genre;
	}
	
	public int getMovieId() {
		return movieId;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getGenre() {
		return genre;
	}
}
