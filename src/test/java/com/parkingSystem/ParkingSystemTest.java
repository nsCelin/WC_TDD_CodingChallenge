package com.parkingSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.parkingSystem.Impl.ParkingSystemImpl;
import com.parkingSystem.Impl.ParkingSystemInterface;

public class ParkingSystemTest {
	private ParkingSystemInterface parking;
	
	final Logger LOGGER  = LoggerFactory.getLogger(ParkingSystemTest .class);

	@Before
	public void setUp() throws Exception {
		parking = new ParkingSystemImpl();
	}

	@Test
	public void CheckForRightForwardOnly()
	{
		parking = new ParkingSystemImpl("5,5:RF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(5, results[0]);
		Assert.assertEquals(6, results[1]);
		
	}
	
	@Test
	public void CheckTurnForRightTowardsNorthToSouth()
	{
		parking = new ParkingSystemImpl("5,5:RFRF");
		int[] results = parking.ProcessInput(); 
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(4, results[0]);
		Assert.assertEquals(6, results[1]);
	}
	
	@Test
	public void CheckTurnForRightTowardsEastToWest()
	{
		parking = new ParkingSystemImpl("5,5:RFRFRF");
		int[] results = parking.ProcessInput(); 
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(4, results[0]);
		Assert.assertEquals(5, results[1]);
	}
	
	
	@Test
	public void CheckForLeftForwardOnly()
	{
		parking = new ParkingSystemImpl("5,5:LF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(5, results[0]);
		Assert.assertEquals(4, results[1]);
	}

	@Test
	public void CheckForLeftTowardsNorthToSouth()
	{
		parking = new ParkingSystemImpl("5,5:LFLF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(4, results[0]);
		Assert.assertEquals(4, results[1]);
	}
	
	@Test
	public void CheckForLeftTowardsWestToEast()
	{
		parking = new ParkingSystemImpl("5,5:LFLFLF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(4, results[0]);
		Assert.assertEquals(5, results[1]);
	}
	
	@Test
	public void CheckForRightForwardWithLeft()
	{
		parking = new ParkingSystemImpl("5,5:RFLF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(6, results[0]);
		Assert.assertEquals(6, results[1]);
		
	}
	
	@Test
	public void CheckForLeftForwardWithRight()
	{
		parking = new ParkingSystemImpl("5,5:LFRF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(6, results[0]);
		Assert.assertEquals(4, results[1]);		
	}
	
	@Test
	public void CheckForForwardThenForwardOnly()
	{
		parking = new ParkingSystemImpl("5,5:FF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(7, results[0]);
		Assert.assertEquals(5, results[1]);
		
	}
	
	@Test
	public void CheckForForwardThenLeftForwardOnly()
	{
		parking = new ParkingSystemImpl("5,5:FLF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(6, results[0]);
		Assert.assertEquals(4, results[1]);
		
	}
	
	@Test
	public void CheckForForwardThenLeftForwardThenForwardOnly()
	{
		parking = new ParkingSystemImpl("5,5:FLFF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(6, results[0]);
		Assert.assertEquals(3, results[1]);
		
	}
	
	@Test
	public void CheckForForwardThenRightForwardOnly()
	{
		parking = new ParkingSystemImpl("5,5:FRF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(6, results[0]);
		Assert.assertEquals(6, results[1]);
		
	}
	
	@Test
	public void CheckForForwardThenRightForwardThenForwardOnly()
	{
		parking = new ParkingSystemImpl("5,5:FRFFF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(6, results[0]);
		Assert.assertEquals(8, results[1]);
		
	}
	
	@Test
	public void CheckInputOne()
	{
		parking = new ParkingSystemImpl("5,5:RFLFRFLF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(7, results[0]);
		Assert.assertEquals(7, results[1]);
		
	}
	
	@Test
	public void CheckInputTwo()
	{
		parking = new ParkingSystemImpl("6,6:FFLFFLFFLFF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(6, results[0]);
		Assert.assertEquals(6, results[1]);
		
	}
	
	@Test
	public void CheckInputThree()
	{
		parking = new ParkingSystemImpl("5,5:FLFLFFRFFF");
		int[] results = parking.ProcessInput();
		
		LOGGER.info("Actual results :"  +results[0] + "," + results[1]);
		
		Assert.assertEquals(4, results[0]);
		Assert.assertEquals(1, results[1]);
		
	}
}
