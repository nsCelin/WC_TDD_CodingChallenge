# WC_TDD_CodingChallenge

* This Application is a Spring Boot Application, built using Maven Project.
* The Design Pattern utilised in this solution is Strategy Design pattern. 
   ParkingSystemContext is the context class where Interface class is injected.
* The solution is designed and coded in Windows OS on Eclipse IDE.
* JUnit has been used to develop TDD.

To run this Program
* Import to project to an IDE and  built this maven project. 
  (Select the project -> Run As  -> Maven Install  Or Use command mvn clean install -e)
* Inorder to run the unit test cases 
    1. Go to the project's test folder. Right click on ParkingSystemTest.java and run as JUnit Test Case.
       The test results will be displayed.
* Inorder to run the project as a Console Application
    1. Run the Program. 
    2. The user will be requested "Enter the string input" on the console
    3. Give the input String as shown below. The input string is the input mentioned in the document provided. (Example : 5,5:FLFLFFRFFF)
        Enter the string input
        5,5:FLFLFFRFFF
        (I have given the third input string in document)
    4.  On  giving enter, the output will be displayed on console as below.
        The output :4,1
        Position along North to South Coordinates(Y-axis) : 4
        Position along West to East Coordinates(X-axis) : 1
        
        
    Assumptions
    * The first position on the output is the Y-axis Co-ordinate/Position along the direction of North-to-South direction on map.
       So in Output (4,1), 4 refers to position along North-to-South direction.
    * The second position on the output is the X-axis Co-ordinate/Position along the direction of West-to-East direction on map.
       So in Output (4,1), 1 refers to position along West-to-East direction.
