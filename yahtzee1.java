/**************
Homework #1
Due Date: 1-29
Names: Michael Newell and Pierce Fleming
***************/
import java.util.*;
import java.lang.*;

public class yahtzee1 
{
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		int DICE_IN_PLAY = 5;
		int[] hand = new int[DICE_IN_PLAY];
		char playAgain = 'y';
		while (playAgain == 'y')
		{
			String keep = "nnnnn";
			int turn = 1;
			while (turn < 4 && keep != "yyyyy")
			{
				for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
				{
					if (keep.charAt(dieNumber) != 'y')
						hand[dieNumber] = rollDie();
				}
				System.out.print("Your roll was: ");
				for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
				{
					System.out.print(hand[dieNumber] + " ");
				}
				System.out.println();
				if (turn < 3)
				{
					System.out.print("enter dice to keep (y or n): ");
					keep = scn.next();
					if(keep.length() != 5)
					{
						System.out.println("Please enter 5 characters next time...");
						return;
					}
				}
				turn++;
			}
			sortArray(hand, DICE_IN_PLAY);
			System.out.print("Here is your sorted hand: ");
			for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
			{
				System.out.print(hand[dieNumber] + " ");
			}
			System.out.println();
			for (int dieValue = 1; dieValue <= 6; dieValue++)
			{
				int currentCount = 0;
				for(int diePosition = 0; diePosition < 5; diePosition++)
				{
					if(hand[diePosition] == dieValue)
						currentCount++;
				}
				System.out.println("Score " + dieValue * currentCount + " on the " + dieValue + " line");
			}
			if (maxOfAKindFound(hand) >= 3)
			{
				System.out.println("Score " + totalAllDice(hand) + " on the 3 of a Kind Line");
			}
			else System.out.println("Score 0 on the 3 of a Kind Line");
			if (maxOfAKindFound(hand) >= 4)
			{
				System.out.println("Score " + totalAllDice(hand) + " on the 4 of a Kind Line");
			}
			else System.out.println("Score 0 on the 4 of a Kind Line");
			if (fullHouseFound(hand))
			{
				System.out.println("Score 25 on the Full House Line");
			}
			else System.out.println("Score 0 on the Full House Line");
			if (maxStraightFound(hand) >= 4)
			{
				System.out.println("Score 30 on the Small Straight Line");
			}
			else System.out.println("Score 0 on the Small Straight Line");
			if (maxStraightFound(hand) >= 5)
			{
				System.out.println("Score 40 on the Large Straight Line");
			}
			else System.out.println("Score 0 on the Large Straight Line");
		if (maxOfAKindFound(hand) >= 5)
			{
				System.out.println("Score 50 on the Yahtzee Line");
			}
			else System.out.println("Score 0 on the Yahtzee Line");
			System.out.println("Score " + totalAllDice(hand) + " on the Chance Line");
			System.out.println("Enter 'y' to play again ");
			playAgain = scn.next().charAt(0);
		}
		return;	
	}
	
	public static int rollDie()
	{
		Random rand = new Random();
		int roll = rand.nextInt(6);
		return roll;
	}
	
	public static int maxOfAKindFound(int hand[])
	{
		int maxCount = 0;
		int currentCount;
		for (int dieValue = 1; dieValue <= 6; dieValue++)
		{
			currentCount = 0;
			for (int diePosition = 0; diePosition < 5; diePosition++)
			{
				if(hand[diePosition] == dieValue)
				{
					currentCount++;
				}
			}
			if (currentCount > maxCount)
			{
				maxCount = currentCount;
			}
		}
		return maxCount;
	}
	
	public static int maxStraightFound(int hand[])
	{
		int maxLength = 1;
		int curLength = 1;
		for (int counter = 0; counter < 4; counter++)
		{
			if (hand[counter] + 1 == hand[counter + 1])
				curLength++;
			else if (hand[counter] + 1 < hand[counter + 1])
				curLength = 1;
			if (curLength > maxLength)
				maxLength = curLength; 
		}
		return maxLength;
	}
	
	public static boolean fullHouseFound(int hand[])
	{
		boolean foundFH = false;
		boolean found3K = false;
		boolean found2K = false;
		int currentCount;
		for (int dieValue = 1; dieValue <= 6; dieValue++)
		{
			currentCount = 0;
			for (int diePosition = 0; diePosition < 5; diePosition++)
			{
				if(hand[diePosition] == dieValue)
					currentCount++;
			}
		
			if (currentCount == 2)
				found2K = true;
			if (currentCount == 3)
				found3K = true;
		}
		if (found2K && found3K)
			foundFH = true;
		return foundFH;
	}
	
	public static int totalAllDice(int hand[])
	{
		int total = 0;
		for (int diePosition = 0; diePosition < 5; diePosition++)
		{
			total += hand[diePosition];
		}
		return total;
	}
	
	public static void sortArray(int array[], int size)
	{
		boolean swap;
		int temp;
		do
		{
			swap = false;
			for (int count = 0; count < (size - 1); count++)
			{
				if (array[count] > array[count + 1])
				{
					temp = array[count];
					array[count] = array[count + 1];
					array[count + 1] = temp;
					swap = true;
				}
			}
		} while (swap);
	}
}
