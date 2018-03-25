package com.parkingSystem.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.parkingSystem.Impl.ParkingSystemInterface;

@Component
public class ParkingSystemContext {
	
	final Logger LOGGER  = LoggerFactory.getLogger(ParkingSystemContext.class);
	
	public void setContext(ParkingSystemInterface parkingInterface)
	{
		LOGGER.info("Entering the ParkingSystemContext setContext Method.");
		parkingInterface.ProcessInput();
	}
	
}
