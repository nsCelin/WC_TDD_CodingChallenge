package com.parkingSystem.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ParkingSystemImpl implements ParkingSystemInterface{

	final Logger LOGGER  = LoggerFactory.getLogger(ParkingSystemImpl.class);
	private String input;
	private int Position1;
	private int Position2;
	
	public ParkingSystemImpl()
	{ }
	
	public ParkingSystemImpl(String input)
	{
		this.input = input;
		LOGGER.info("The String Input: " + this.input);
	}
	
	@Override
	public int[] ProcessInput() {
		
		int[] results = new int[2];
		LOGGER.info("Entering the ProcessInput Method.");
		String inputs[] = this.input.split(":");
		String positions[] = inputs[0].split(",");
		       
		PresentArrayInputs(positions);
		try
		{
			results  = processCommands(inputs[1]);
		}
		catch(Exception e)
		{
			LOGGER.error("Exception : " + e.getMessage());
		}
		return results;
		
	}
	
	public void PresentArrayInputs(String[] pos)
	{
		 LOGGER.info("Entering the PresentArrayInputs Method.");
		 
		 this.Position1 = Integer.parseInt(pos[0]);
		 this.Position2 = Integer.parseInt(pos[1]);
		 
         LOGGER.info("Entering the input positions. Position1 : " +this.Position1 + ". Position2 : " + this.Position2);
	}
	
	private int[] processCommands(String sInput)
	{
		LOGGER.info("Entering the processCommands Method.");
		 
		int finalPosition[] = new int[2];
	    int count = 0;
	    int pos1 = this.Position1;
	    int pos2 = this.Position2;
	    int prevPos1 = 0;
	    int prevPos2 = 0;
	    String dir = "";
	    String[] input = sInput.split("");
	    
		while(count < input.length)
		{
			char presntChar = sInput.charAt(count);
			LOGGER.info("The Present Character : " +presntChar );
			
			if(presntChar == 'F')
			{
				LOGGER.info("Entering the processCommands Method. The Present Character is F.");
				
				/*When the first position of the input is F. 
				 * Always the car faces north in that position, 
				 * so it moves forward to the upper position */
				if(dir == "")
				{
					LOGGER.info("When the first position is F.");
					
					prevPos1 = this.Position1;
					prevPos2 = this.Position2;
					pos1 = this.Position1;
					pos2 = this.Position2+1;
					dir = "Y";
					
					LOGGER.info("The positions are : prevPos1 : " +prevPos1 +  ", prevPos2 :  "+prevPos2 +
							", pos1 : " + pos1 + ", pos2 : " + pos2 + ", dir : " + dir);
				}
				else if(dir == "Y")
				{
					/*When the car is facing from North to South. 
					 * And a forward position moves it further south,
					 * towards Y-axis */
					if(pos2 - prevPos2 == -1)
					{
						LOGGER.info("When the direction is along Y-axis(North to South) and car wants "
								+ "to move forward along Y-axis.");
						
						prevPos1 = pos1;
						prevPos2 = pos2;
						pos2 = pos2 -1;
						
						LOGGER.info("The positions are : prevPos1 : " +prevPos1 +  ", prevPos2 :  "+prevPos2 +
								 ", pos2 : " + pos2);
					}
					
					/*When the car is facing from South to North. 
					 * And a forward position moves it further north,
					 * towards Y-axis */
					if(pos2 - prevPos2 == 1)
					{
						LOGGER.info("When the direction is along Y-axis(South to North) and car wants "
								+ "to move forward along Y-axis.");
						
						prevPos1 = pos1;
						prevPos2 = pos2;
						pos2 = pos2+1;
						
						LOGGER.info("The positions are : prevPos1 : " +prevPos1 +  ", prevPos2 :  "+prevPos2 +
								 ", pos2 : " + pos2);
					}
					
					dir = "Y";
					
					LOGGER.info("The current direction of car : " + dir);
				}
				else if(dir == "X")
				{
					/*When the car is facing from East to West. 
					 * And a forward position moves it further West,
					 * towards X-axis */
					if(pos1 - prevPos1 == -1)
					{
						LOGGER.info("When the direction is along X-axis(East to West) and car wants "
								+ "to move forward along X-axis.");
						
						prevPos1 = pos1;
						prevPos2 = pos2;
						pos1 = pos1 -1;
						
						LOGGER.info("The positions are : prevPos1 : " +prevPos1 +  ", prevPos2 :  "+prevPos2 +
								 ", pos1 : " + pos1);
					}
					/*When the car is facing from West to East. 
					 * And a forward position moves it further East,
					 * towards X-axis */
					if(pos1 - prevPos1 == 1)
					{
						LOGGER.info("When the direction is along X-axis(West to East) and car wants "
								+ "to move forward along X-axis.");
						
						prevPos1 = pos1;
						prevPos2 = pos2;
						pos1 = pos1+1;
						
						LOGGER.info("The positions are : prevPos1 : " +prevPos1 +  ", prevPos2 :  "+prevPos2 +
								 ", pos1 : " + pos1);
					}
					dir = "X";
					
					LOGGER.info("The current direction of car : " + dir);
				}               
			}
			else
			{
			    int secCount = count+1;
				while(secCount < input.length)
			    {
						char nextChar = sInput.charAt(secCount);
						LOGGER.info("The Next Character : " +nextChar );
						
						if(presntChar == 'L' && nextChar == 'F')
						{
							LOGGER.info("Entering the loop for Left and Forward Logic");
							
							/*When the starting input is Left and Forward*/
							if(Position1 == pos1 && Position2 == pos2)
							{
								LOGGER.info("When the starting point is Left and Forward.");
								
								prevPos1 = pos1;
								prevPos2 = pos2;
								pos1 = this.Position1 - 1;
								pos2 = this.Position2;
								dir = "X"; //next direction
								
								LOGGER.info("The positions are : prevPos1 : " +prevPos1 +  ", prevPos2 :  "+prevPos2 +
										 ", pos1 : " + pos1 + ", pos2 : " + pos2 + ", dir : " + dir);
							}
							
							/*The position of the car is pointing to right along X-axis(W -> E  direction)
							 * and intending to turn its left 
							 * (towards S -> N direction upward)*/
							else if(pos1 - prevPos1 == 1 && dir.equals("X"))
							{
								LOGGER.info("When the direction is along X-axis(West to East) and car wants "
										+ "to turn left (South to North).");
								
								prevPos2 = pos2;
								pos2 = pos2+1;
								dir = "Y"; //next direction
								
								LOGGER.info("The positions are : prevPos2 : " +prevPos2 +  
										 ", pos2 : " + pos2 + ", dir : " + dir);
							}
														
							/*The position of the car is pointing to right along X-axis(E -> W  direction)
							 * and intending to turn its left 
							 * (towards N -> S direction downward)*/
							else if(pos1 - prevPos1 == -1 && dir.equals("X"))
							{
								LOGGER.info("When the direction is along X-axis(East to West) and car wants "
										+ "to turn left (North to South).");
								
								prevPos2 = pos2;
								pos2 = pos2 -1;
								dir = "Y";
								
								LOGGER.info("The positions are : prevPos2 : " +prevPos2 +  
										 ", pos2 : " + pos2 + ", dir : " + dir);
							}
							
							/*The position of the car is pointing to right along Y-axis(N -> S  direction)
							 * and intending to turn its left 
							 * (towards W -> E direction rightward)*/
							else if(pos2 - prevPos2 == -1 && dir.equals("Y"))
							{
								LOGGER.info("When the direction is along Y-axis(North to South) and car wants "
										+ "to turn left (West to East).");
								
								prevPos1 = pos1;
								pos1 = pos1+1;
								dir = "X"; 
								
								LOGGER.info("The positions are : prevPos1 : " +prevPos1 +  
										 ", pos1 : " + pos1 + ", dir : " + dir);
							}
							
							/*The position of the car is pointing to right along Y-axis(S -> N  direction)
							 * and intending to turn its left 
							 * (towards E -> W direction leftward)*/
							else if(pos2 - prevPos2 == 1 && dir.equals("Y"))
							{
								LOGGER.info("When the direction is along Y-axis(South to North) and car wants "
										+ "to turn left (East to West).");
								
								prevPos1 = pos1;
								pos1 = pos1-1;
								dir = "X";
								
								LOGGER.info("The positions are : prevPos1 : " +prevPos1 +  
										 ", pos1 : " + pos1 + ", dir : " + dir);
							}
							count++;
							break;
						}
						else if(presntChar == 'R' && nextChar == 'F') 
						{
							LOGGER.info("Entering the loop for Right and Forward Logic");
							
							/*When the starting input is Right and Forward*/
							if(Position1 == pos1 && Position2 == pos2)
							{
								LOGGER.info("When the starting position is right and forward.");
								
								prevPos1 = pos1;
								prevPos2 = pos2;
								pos1 = this.Position1 + 1;
								pos2 = this.Position2;
								dir = "X";
								
								LOGGER.info("The positions are : prevPos1 : " +prevPos1 +  ", prevPos2 : " + prevPos2 +
										 ", pos1 : " + pos1 + ", pos2 : " + pos2 + ", dir : " + dir);
							}
							
							/*The position of the car is pointing to right along X-axis(W -> E  direction)
							 * and intending to turn its right 
							 * (towards N -> S direction downward)*/
							else if(pos1 - prevPos1 == 1 && dir.equals("X"))
							{
								LOGGER.info("When the direction is along X-axis(West to East) and car wants "
										+ "to turn right (North to South).");
								
								prevPos2 = pos2;
								pos2 = pos2-1;	
								dir = "Y";
								
								LOGGER.info("The positions are :  prevPos2 : " + prevPos2 +
										 ", pos2 : " + pos2 + ", dir : " + dir);
							}
							
							/*The position of the car is pointing to right along X-axis(E -> W direction)
							 * and intending to turn its right 
							 * (towards S -> N direction upward)*/
							else if(pos1 - prevPos1 == -1 && dir.equals("X"))
							{
								LOGGER.info("When the direction is along X-axis(East to West) and car wants "
										+ "to turn right (South to North).");
								
								prevPos2 = pos2;
								pos2 = pos2+1;
								dir = "Y";
								
								LOGGER.info("The positions are :  prevPos2 : " + prevPos2 +
										 ", pos2 : " + pos2 + ", dir : " + dir);
							}
							
							/*The position of the car is pointing to right along Y-axis(N -> S direction)
							 * and intending to turn its right 
							 * (towards E -> W direction leftward)*/
							else if(pos2 - prevPos2 == -1 && dir.equals("Y"))
							{
								LOGGER.info("When the direction is along Y-axis(North to South) and car wants "
										+ "to turn right (East to West).");
								
								prevPos1 = pos1;
								pos1 = pos1-1;
								dir = "X";
								
								LOGGER.info("The positions are :  prevPos1 : " + prevPos1 +
										 ", pos1 : " + pos1 + ", dir : " + dir);
							}
							
							/*The position of the car is pointing to right along Y-axis(S -> N direction)
							 * and intending to turn its right 
							 * (towards W -> E direction rightward)*/
							else if(pos2 - prevPos2 == 1 && dir.equals("Y"))
							{
								LOGGER.info("When the direction is along Y-axis(South to North) and car wants "
										+ "to turn right (West to East).");
								
								prevPos1 = pos1;
								pos1 = pos1 +1;
								dir = "X";
								
								LOGGER.info("The positions are :  prevPos1 : " + prevPos1 +
										 ", pos1 : " + pos1 + ", dir : " + dir);
							}
							count++;
							break;
						}
				}
			}
			
			count++;
	
		}
		
		System.out.println("The output :" + pos2 + "," + pos1);
		System.out.println("Position along North to South Coordinates(Y-axis) : " +pos2);
		System.out.println("Position along West to East Coordinates(X-axis) : " +pos1);
		
		LOGGER.info("The output : " +   pos2 + "," + pos1);
		LOGGER.info("Position along North to South Y-Axis : " +  pos2);
		LOGGER.info("Position along West to East X-Axis : " +  pos1);
		finalPosition[0] = pos2;
		finalPosition[1] = pos1;
		return finalPosition;
	}
	

}
