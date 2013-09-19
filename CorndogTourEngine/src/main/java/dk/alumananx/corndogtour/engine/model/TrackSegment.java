package dk.alumananx.corndogtour.engine.model;

public class TrackSegment {

	private double distance;
	private double height;
	private double headwind;
	private double position;
	private double temperature;
	private double grade;
	private double previousHeight;

	public TrackSegment() {
	}
	
	public TrackSegment(double distance, double height, double previousHeight, double headwind, double position, double temperature) {
		super();
		this.distance = distance;
		this.height = height;
		this.previousHeight = previousHeight;
		this.headwind = headwind;
		this.position = position;
		this.temperature = temperature;
		this.grade = (height - previousHeight) / (distance * 10);
		System.out.println("Grade calculation: " + this.grade);
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeadwind() {
		return headwind;
	}

	public void setHeadwind(double headwind) {
		this.headwind = headwind;
	}

	public double getPosition() {
		return position;
	}

	public void setPosition(double position) {
		this.position = position;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "TrackSegment [distance=" + distance + ", height=" + height
				+ ", headwind=" + headwind + ", position=" + position
				+ ", temperature=" + temperature + ", grade=" + grade + "]";
	}

	public double getPreviousHeight() {
		return previousHeight;
	}

	public void setPreviousHeight(double previousHeight) {
		this.previousHeight = previousHeight;
	}

}
