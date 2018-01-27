package multiplex.model;

import java.util.Date;

public class Bookings {

	private int bookingNo;
	private int showId;
	private int userId;
	private Date bookingDate;
	private Date showDate;
	private String seatTypeDesc;
	
	
	public Bookings(int bookingNo, int showId, int userId, Date bookingDate, Date showDate, String seatTypeDesc,
			int noOfSeat) {
		super();
		this.bookingNo = bookingNo;
		this.showId = showId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.showDate = showDate;
		this.seatTypeDesc = seatTypeDesc;
		this.noOfSeat = noOfSeat;
	}
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public String getSeatTypeDesc() {
		return seatTypeDesc;
	}
	public void setSeatTypeDesc(String seatTypeDesc) {
		this.seatTypeDesc = seatTypeDesc;
	}
	public int getNoOfSeat() {
		return noOfSeat;
	}
	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}
	private int noOfSeat;

}
