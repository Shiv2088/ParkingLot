package com.parking.lot.service;

import java.io.BufferedReader;
import java.io.IOException;

import com.parking.lot.entity.Car;
import com.parking.lot.entity.ParkingSlot;

public class ParkingService {

	private static ParkingSlot parkingSlot[];
	private static int chargedAmt;
	private static int parkingSize;

	public static void startParking(BufferedReader reader, String line) throws IOException {
		while (line != null) {
			if (line.startsWith("create")) {
				createParkingSlot(line);
			} else if (line.startsWith("park")) {
				if (isNotFull(parkingSlot)) {
					carParking(line);
				} else {
					System.out.println("Sorry, parking lot is full");
					line = reader.readLine();
					continue;
				}
			} else if (line.startsWith("leave")) {
				vacantSlot(line);
				line = reader.readLine();
				continue;
			} else if (line.startsWith("status")) {
				System.out.println("Slot No.  Registration No.");
				for (ParkingSlot slot : parkingSlot) {
					if (!slot.isEmpty()) {
						System.out.println(slot.getSlotNo() + "  " + slot.getCar().getCarNo());
					}
				}
			}
			// read next line
			line = reader.readLine();
		}
	}

	private static void vacantSlot(String line) {
		String splitedLine[] = line.split(" ");
		String regNo = splitedLine[1];
		String carNo = null;
		calculateCharge(splitedLine);
		for (ParkingSlot slot : parkingSlot) {
			if (slot.getCar() != null && regNo.equals(slot.getCar().getCarNo())) {
				carNo = slot.getCar().getCarNo();
				System.out.println("Registration number " + carNo + " with Slot Number " + slot.getSlotNo()
						+ " is free with Charge " + chargedAmt);
				slot.setEmpty(true);
				slot.setCar(null);
				break;
			}
		}
		printLeavingCarDetails(regNo, carNo);
	}

	private static void calculateCharge(String[] splitedLine) {
		int hour = Integer.valueOf(splitedLine[splitedLine.length - 1]);
		if (hour <= 2) {
			chargedAmt = 10;
		} else {
			chargedAmt = (hour * 10) - 10;
		}
	}

	private static void printLeavingCarDetails(String regNo, String carNo) {
		if (!regNo.equals(carNo)) {
			System.out.println("Registration number " + regNo + " not found");
		}
	}

	private static void carParking(String line) {
		for (ParkingSlot slot : parkingSlot) {
			if (slot.isEmpty()) {
				allocateSlot(line, slot);
				generateTicket(line);
				System.out.println("Allocated slot number: " + slot.getSlotNo());
				break;

			}
		}
	}

	private static void allocateSlot(String line, ParkingSlot slot) {
		String regNo = line.split(" ")[1];
		Car car = new Car();
		car.setCarNo(regNo);
		slot.setEmpty(false);
		slot.setCar(car);

	}

	private static void generateTicket(String regNo) {
		// TODO Auto-generated method stub

	}

	private static void createParkingSlot(String line) {
		String splitedLine[] = line.split(" ");
		parkingSize = Integer.valueOf(splitedLine[1]);
		parkingSlot = new ParkingSlot[parkingSize];
		for (int i = 0; i < parkingSlot.length; i++) {
			ParkingSlot slot = new ParkingSlot();
			slot.setSlotNo(i + 1);
			parkingSlot[i] = slot;
		}
		System.out.println("Created parking lot with " + parkingSize + " slots");
	}

	private static boolean isNotFull(ParkingSlot[] arr) {
		for (ParkingSlot parkingSlot : arr) {
			if (parkingSlot.isEmpty()) {
				return true;
			}
		}
		return false;
	}
}
