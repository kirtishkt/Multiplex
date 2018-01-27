package multiplex.model;

import java.util.Date;

public class Shows {

	private int showId;
	private int hallId;
	private int movieId;
	private int slotNo;
	private Date fromDate;
	private Date toDate;
	
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getSlotNo() {
		return slotNo;
	}
	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Shows(int showId, int hallId, int movieId, int slotNo, Date fromDate, Date toDate) {
		super();
		this.showId = showId;
		this.hallId = hallId;
		this.movieId = movieId;
		this.slotNo = slotNo;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public Shows() {
		// TODO Auto-generated constructor stub
	}

	

}
