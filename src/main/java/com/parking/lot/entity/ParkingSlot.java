package com.parking.lot.entity;

public class ParkingSlot {
	private int slotNo;
	private int floor;
	private boolean isEmpty = true;
	private ParkingLot parkinglot;
	private Car car;

	public int getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public ParkingLot getParkinglot() {
		return parkinglot;
	}

	public void setParkinglot(ParkingLot parkinglot) {
		this.parkinglot = parkinglot;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + floor;
		result = prime * result + (isEmpty ? 1231 : 1237);
		result = prime * result + ((parkinglot == null) ? 0 : parkinglot.hashCode());
		result = prime * result + slotNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingSlot other = (ParkingSlot) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (floor != other.floor)
			return false;
		if (isEmpty != other.isEmpty)
			return false;
		if (parkinglot == null) {
			if (other.parkinglot != null)
				return false;
		} else if (!parkinglot.equals(other.parkinglot))
			return false;
		if (slotNo != other.slotNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParkingSlot [slotNo=" + slotNo + ", floor=" + floor + ", isEmpty=" + isEmpty + ", parkinglot="
				+ parkinglot + ", car=" + car + "]";
	}
}
