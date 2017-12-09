import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @author priyankadey
 * the class that has all the functions.
 */
public class Game {
	/**
	 * there are 3 heaps in the game. each are initialized with objects between 1 to 10.
	 */
	static int heap1 = 1 + (int)(Math.random() * 10); 
	static int heap2 = 1 + (int)(Math.random() * 10);
	static int heap3 = 1 + (int)(Math.random() * 10);

	static int whoIsPlaying = 0; // 0 if computer is playing, 1 if player is playing
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return finds the x-or given three inputs.
	 */
	public static int findNimSum(int x, int y, int z) {
		return x^y^z;
	}

	/**
	 * all logic for when the player plays.
	 */
	public static void userPlays() {
		System.out.println("Which heap would you like to take objects from?");
		Scanner heapNumber = new Scanner(System.in);
		int heapNo = heapNumber.nextInt();
		while ((heapNo != 1) && (heapNo!= 2) && (heapNo != 3)) {
			System.out.println("You entered an invalid heap number. Enter again.");
			heapNo = heapNumber.nextInt();
		}
		
		System.out.println("How many objects would you like to take?");
		int objectNumber = heapNumber.nextInt();
		
		// modify the value of the heap the user wants to take from
		switch(heapNo) {
			case 1: while (objectNumber > heap1) {
						System.out.println("You entered an invalid number of objects. Enter again.");
						objectNumber = heapNumber.nextInt();
					}
					heap1 -= objectNumber;
				    break;
			case 2: while (objectNumber > heap2) {
						System.out.println("You entered an invalid number of objects. Enter again.");
						objectNumber = heapNumber.nextInt();
					}
					heap2 -= objectNumber;
					break;
			case 3: while (objectNumber > heap3) {
						System.out.println("You entered an invalid number of objects. Enter again.");
						objectNumber = heapNumber.nextInt();
					}
					heap3 -= objectNumber;
					break;
			default: break;
			
		}
		
		System.out.println ("Heap1: " + heap1);
		System.out.println ("Heap2: " + heap2);
		System.out.println ("Heap3: " + heap3);
		
	}
	
	/**
	 * computer finds the nim sum of all heaps (X)
	 * then finds nimsum of X with each heap
	 * finds whether or not the sum is less than the heap size.
	 * makes the heap size equal to the sum.
	 */
	public static void computerPlays() {
		System.out.println("Computer is currently playing...");
	
		int totalNimSum = findNimSum(heap1, heap2, heap3);
		
		int A = 11, B = 11, C = 11;
		
		// compute all the nim sums assuming the heap size is not 0
		if (heap1 != 0)
			A = findNimSum(heap1, totalNimSum, 0);
		if (heap2 != 0) 
			B = findNimSum(heap2, totalNimSum, 0);
		if(heap3 != 0) 
			C = findNimSum(heap3, totalNimSum, 0);
		
		// find the nim sum that's less than the size of the heap and make the heap equal to that one
		if (A < heap1) 
			heap1 = A;
		else if (B < heap2) 
			heap2 = B;
		else if (C < heap3) 
			heap3 = C;
		
		System.out.println ("Heap1: " + heap1);
		System.out.println ("Heap2: " + heap2);
		System.out.println ("Heap3: " + heap3);
			
	}
	
	/**
	 * 
	 * @return finds the winner.
	 */
	public static int findWinner() {
		if ((heap1 == 0) && (heap2 == 0) && (heap3 == 0)) {
			return whoIsPlaying;
		}
		else {
			return -1;
		}
	}
	
	
	/**
	 * basically just decide who plays first and execute the game.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Have Fun Playing Nim!");
		
		System.out.println("Enter 'Y' to play first. Enter 'N' to let computer play first.");
		Scanner playFirst = new Scanner(System.in);
		String c = playFirst.nextLine();
		
		System.out.println ("Heap1: " + heap1);
		System.out.println ("Heap2: " + heap2);
		System.out.println ("Heap3: " + heap3);
		
		if (c == "Y") {
			while (((heap1 != 0) || (heap2 != 0) || (heap3 != 0))) {
				userPlays();
				if ((heap1 == 0) && (heap2 == 0) && (heap3 == 0)) {
					int winner = findWinner();
					if (winner != (-1)) {
						break;
					}
				}
			computerPlays();
			}
		
		}
		else {
			while (((heap1 != 0) || (heap2 != 0) || (heap3 != 0))) {
				computerPlays();
				if ((heap1 == 0) && (heap2 == 0) && (heap3 == 0)) {
					int winner = findWinner();
					if (winner != (-1)) {
						break;
					}
				}
				userPlays();
			}
		
			switch(whoIsPlaying) {
			case 0: System.out.println("The winner is: the Computer!! You LOST!");
					break;
			case 1: System.out.println("You are the winner! Congrats!!!");
					break;
			}
		
		}
	}
		
}
