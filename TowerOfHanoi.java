package towerOfHanoi;

import java.util.*;

public class TowerOfHanoi {
	
	//we can solve tower of hanoi using Stack, so first create a stack class
	class Stack
	{
	    int totalDisk;
	    int top;
	    int array[];
	}
	///initializing the stack
	Stack initializationStack(int totalDisk)
	{
	    Stack stack = new Stack();
	    stack.totalDisk = totalDisk;
	    stack.top = -1;
	    stack.array = new int[totalDisk];
	    return stack;
	}
	
	
	void iterativeTowerOfHanoi(int n, Stack
	                fast, Stack aux, Stack dest)
	{
	    int i, movementOfDsks;
	    char s = 'S', d = 'D', a = 'A';
	    if (n % 2 == 0)
	    {
	        char temp = d;
	        d = a;
	        a = temp;
	    }
	    
	   // for solving the tower of hanoi using iteration we have to apply iteration formula of Tower of Hanoi
	    
	    movementOfDsks = (int)(Math.pow(
	                        2, n) - 1);
	    for(i = n; i >= 1; i--)
	        push(fast, i);
	    for(i = 1; i <= movementOfDsks; i++)
	    {
	        if (i % 3 == 1)
	        movementOfDsk(fast, dest, s, d);
	        else if (i % 3 == 2)
	        movementOfDsk(fast, aux, s, a);
	        else if (i % 3 == 0)
	        movementOfDsk(aux, dest, a, d);
	    }
	}
	
	void movementOfDsk(Stack fast, Stack dest,
            char s, char d)
	{
		int dskOne = pop(fast);
		int dskTwo = pop(dest);
		if (dskOne == Integer.MIN_VALUE)
		{
		push(fast, dskTwo);
		printmovementOfDsk(d, s, dskTwo);
		}

		else if (dskTwo == Integer.MIN_VALUE)
		{
		push(dest, dskOne);
		printmovementOfDsk(s, d, dskOne);
		}
		else if (dskOne > dskTwo)
		{
		push(fast, dskOne);
		push(fast, dskTwo);
		printmovementOfDsk(d, s, dskTwo);
		}
		else
		{
		push(dest, dskTwo);
		push(dest, dskOne);
		printmovementOfDsk(s, d, dskOne);
		}
		}
	
	// push and pop operation of the stack
		void push(Stack stack, int item)
		{
		    if (isStackFull(stack)) {
		        return;
		    }
		        
		    stack.array[++stack.top] = item;

	}
		int pop(Stack stack)
		{
		    if (isStackEmpty(stack))
		        return Integer.MIN_VALUE;
		        
		    return stack.array[stack.top--];
		}
		
		
		boolean isStackFull(Stack stack)
		{
		    return (stack.top == stack.totalDisk - 1);
		}
		boolean isStackEmpty(Stack stack)
		{
		    return (stack.top == -1);
		}
	// printing the result
	void printmovementOfDsk(char from, char to, int disk)
	{
	    System.out.println("movementOfDsk the disk " + disk +
	                            " from " + from +
	                            " to " + to);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 int n = scanner.nextInt();
	    
	    TowerOfHanoi object = new TowerOfHanoi();
	    Stack source = object.initializationStack(n);
	    Stack destination = object.initializationStack(n);
	      Stack temprorary = object.initializationStack(n);
	    
	    object.iterativeTowerOfHanoi(n, source, temprorary, destination);
	    }
	}
