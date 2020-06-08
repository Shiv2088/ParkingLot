package com.parking.lot.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.parking.lot.service.ParkingService;

public class ParkingApplication {
	

	public static void main(String[] args) {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\Documents\\parking_lot file_inputs.txt"));
			String line = reader.readLine();
			ParkingService.startParking(reader, line);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
