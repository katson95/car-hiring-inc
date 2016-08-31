package co.uk.vehicle.inc.entity.constant;

public enum Status {

	AVAILABLE("Available"), BOOKED("Booked");

	private final String name;

	private Status(String s) {
		name = s;
	}

	public String getName() {
		return this.name;
	}

	public boolean equalsName(String otherName) {
		return (otherName == null) ? false : name.equals(otherName);
	}
}
