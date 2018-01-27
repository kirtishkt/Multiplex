package multiplex.model;

public class HallCapacities {
	
	private int hallId;
	private String seatTypeDesc; 
	private int seatCount;
	private int seatFare;
	
	public HallCapacities(int hallId, String seatTypeDesc, int seatCount, int seatFare) {
		super();
		this.hallId = hallId;
		this.seatTypeDesc = seatTypeDesc;
		this.seatCount = seatCount;
		this.seatFare = seatFare;
	}
	
	public int getHallId() {
		return hallId;
	}
	
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public String getSeatTypeDesc() {
		return seatTypeDesc;
	}
	public void setSeatTypeDesc(String seatTypeDesc) {
		this.seatTypeDesc = seatTypeDesc;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	public int getSeatFare() {
		return seatFare;
	}
	public void setSeatFare(int seatFare) {
		this.seatFare = seatFare;
	}


}
