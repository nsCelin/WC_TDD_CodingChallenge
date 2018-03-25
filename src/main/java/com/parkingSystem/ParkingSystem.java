package com.parkingSystem;


import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.parkingSystem.Impl.ParkingSystemImpl;
import com.parkingSystem.context.ParkingSystemContext;

@SpringBootApplication
public class ParkingSystem {

	final Logger LOGGER  = LoggerFactory.getLogger(ParkingSystem.class);
	
	public static void main(String[] args) throws Exception{
		
		ParkingSystem system = new ParkingSystem();
		system.LOGGER.info("Entering the Spring Boot Application.");
		
		SpringApplication.run(ParkingSystem.class, args);
		System.out.println("Enter the string input");  
		Scanner scan=new Scanner(System.in);  		
		String input = scan.nextLine();
		scan.close();  
		
		system.LOGGER.info("Calling the Context Class.");
		ParkingSystemContext parkingSystemContext = new ParkingSystemContext();
		parkingSystemContext.setContext(new ParkingSystemImpl(input));

	}

}
