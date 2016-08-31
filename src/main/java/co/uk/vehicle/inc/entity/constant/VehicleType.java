package co.uk.vehicle.inc.entity.constant;

public enum VehicleType {

	CAR("Car"), VAN("Van"), CONVERTIBLE("Convertible"), MOTORBIKE("Motorbike");

	private final String name;

	private VehicleType(String s) {
		name = s;
	}

	public String getName() {
		return this.name;
	}

	public boolean equalsName(String otherName) {
		return (otherName == null) ? false : name.equals(otherName);
	}
}
