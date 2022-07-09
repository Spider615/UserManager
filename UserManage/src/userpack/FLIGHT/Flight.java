package userpack.FLIGHT;

public class Flight {
	private int flightId;
	private String flightTo;
	private double flightTime;
	private double flightSetTime;
	public Flight(int flightId, String flightTo, double flightTime,double flightSetTime) {
		super();
		this.flightId = flightId;
		this.flightTo = flightTo;
		this.flightTime = flightTime;
		this.flightSetTime = flightSetTime;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightTo() {
		return flightTo;
	}
	public void setFlightTo(String flightTo) {
		this.flightTo = flightTo;
	}
	public double getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(double flightTime) {
		this.flightTime = flightTime;
	}
	public double getFlightSetTime() {
		return flightSetTime;
	}
	public void setFlightSetTime(double flightSetTime) {
		this.flightSetTime = flightSetTime;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightTo=" + flightTo + ", flightTime=" + flightTime
				+ ", flightSetTime=" + flightSetTime + "]";
	}
	
	
	

}
