import java.util.*;

public class ConversionProg
{
  
  public static void main(String[] args)
  {
    Scanner scn = new Scanner(System.in);
    
  
    double dist;
    
    int num;
    do{
    	System.out.println("Please enter a distance in meters: ");
    	dist = scn.nextDouble();
    	menu();
    	if (scn.hasNextInt())
    	{
    		num = scn.nextInt();
    	} else {
     		System.out.println("Error: invalid expression");
      		return;
    	}
    	if (num == 1)
    	{
      		showKilometers(dist);
    	} else if (num == 2)
    	{
     		showInches(dist);
    	} else if (num == 3)
    	{
      		showFeet(dist);
    	} else if (num == 4)
    	{
    		System.out.println("Goodbye, have a nice day!");
    	} else {
      		System.out.println("What?");
    	}
    }
    while (num != 4);
  }
  
  public static void menu()
  {
    System.out.println("Please enter the number of the option:");
    System.out.println("1. Convert to Kilmeters ");
    System.out.println("2. Convert to inches ");
    System.out.println("3. Convert to feet ");
    System.out.println("4. Exit the program "); 
  }
  
  public static void showInches(double dist)
  {
    System.out.println(dist * 39.37);
  }
  
  public static void showFeet(double dist)
  {
    System.out.println(dist * 3.281);
  }
  
  public static void showKilometers(double dist)
  {
    System.out.println(dist * .001);
  }
}
