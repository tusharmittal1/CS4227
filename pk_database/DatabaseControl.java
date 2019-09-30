package pk_database;

import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;

import pk_factory.Factory;
import pk_movies.Movie;
import pk_movies.MovieListing;
import pk_users.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;

public class DatabaseControl {
		
	private Connection connect;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private Factory uf;
	private int seatId;
	
	public DatabaseControl(){
		try {
			loadDatabase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadDatabase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/project","puser","pass");
			statement = connect.createStatement();
			}catch(Exception e) {
				throw e;
			}
	}
	
	public ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<>();
		uf= new Factory();
		try {
			resultSet = statement.executeQuery("select * from users");
			while(resultSet.next()) {
				if(resultSet.getString(4) == "1") {
				users.add(uf.instanceCustomer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
				}
				else {
					users.add(uf.instanceManager(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
				}
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public ArrayList<Movie> getMovies(){
		ArrayList<Movie> movies = new ArrayList<>();
		try {
			resultSet = statement.executeQuery("select * from movies");
			while(resultSet.next()) {
				movies.add(new Movie(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
				}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}
	
	public void addUser(String username, String password) {
		try {
			preparedStatement = connect.prepareStatement("insert into Users values (default, ?, ?, '1')");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<MovieListing> getDates(String name) {
		ArrayList<MovieListing> listings = new ArrayList<>();
		try { 
			preparedStatement = connect.prepareStatement("Select listId, movie,date, time  from movieListings JOIN movies ON movieListings.movie=movies.movieId where movieName = ?");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int listingId = resultSet.getInt(1);
				int movieId = resultSet.getInt(2);
				java.util.Date date = resultSet.getDate(3);
				String time = resultSet.getString(4);
				listings.add(new MovieListing(listingId, movieId, date, time));
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listings;
	}
	
	public String getSeats(int listId) {
		String seats = "";
		try {
			preparedStatement = connect.prepareStatement("Select seatsId, seat from seats where listingId = ?");
			preparedStatement.setInt(1, listId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			seatId = resultSet.getInt(1);
			seats = resultSet.getString(2);
			}
			preparedStatement.close();
			resultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seats;
	}
	
	public void setSeats(String seat) {
		try {
			System.out.print(seat);
			preparedStatement = connect.prepareStatement("UPDATE seats SET seat = ? WHERE seatsId = ?");
			preparedStatement.setString(1, seat);
			preparedStatement.setInt(2, seatId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addBooking(int userId, int listingId, int seatNo , String paymentTyp ) {
		try {
			System.out.print(userId);
			preparedStatement = connect.prepareStatement("insert into bookings values (default, ?, ?,?,?, default)");
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, listingId);
			preparedStatement.setInt(3, seatNo);
			preparedStatement.setString(4, paymentTyp);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
