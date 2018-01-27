package multiplex.model;

public class Movies {
	
	private int movieId;
	private String movieName;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Movies(int movieId, String movieName) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
	}
	
}
