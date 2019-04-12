public class ABStack<T> 
{
	
	private T[] stack;
	int top;
	final int CAPACITY = 10;
	
	
	public ABStack()
	{
		top = -1;
		stack = (T[]) new Object[CAPACITY];
		
	}
	public ABStack(ABStack other)
	{
		this.top = other.top;
		this.stack = (T[]) new Object[other.stack.length];
		for(int i = 0; i <= other.top; i++)
		{
			this.stack[i] = (T)other.stack[i];
		}
	}
	public void copy(ABStack other)
	{
		this.top = other.top;
		this.stack = (T[]) new Object[other.stack.length];
		for(int i = 0; i <= other.top; i++)
		{
			this.stack[i] = (T)other.stack[i];
		}
	}
	public ABStack copy()
	{
		T[] newStack = (T[]) new Object[stack.length];
		for(int i = 0; i <= top; i++)
		{
			newStack[i] = (T)stack[i];
		}
		ABStack newStacks = new ABStack(stack.length);
		for(int i = 0; i <= top; i++)
		{
			newStacks.push((T)newStack[i]);
		}
		return newStacks;
	}
	
	public ABStack(int capacity)
	{
		if(capacity <= 0)
		{
			System.out.println("Invalid Capacity Provided. Default Capacity will be used.");
			stack = (T[]) new Object[CAPACITY];
		}
		else
		{
			stack = (T[]) new Object[capacity];
		}
		top = -1;
	}
	
	public void push(T item)
	{
		if(isFull())
		{
			int newSize = top + 1 + CAPACITY;
			T[] newStack = (T[])new Object[newSize];
			for(int i = 0; i <= top; i++)
			{
				newStack[i] = stack[i];
			}
			stack = newStack;
		}
		top++;
		stack[top] = item;
	}
	
	public boolean isFull()
	{
		if(top == stack.length - 1)
		{
			return true;
		}
		else 
		{
			return false;
		}

	}

	public boolean isEmpty()
	{
		return(top == -1);
	}
	
	public T pop()
	{
		T topItem = null;
		if(!isEmpty())
		{
			topItem = stack[top];
			top--;
		}
		else
		{
			System.out.println("Stack is Empty.");
		}
		return topItem;
	}
	
	public T peek()
	{
		T topItem = null;
		if(!isEmpty())
		{
			topItem = stack[top];
		}
		else
		{
			System.out.println("Stack is Empty.");
		}
		return topItem;
	}
	
	public String toString()
	{
		String str = "[";
		for(int i = 0; i <= top; i++)
		{
			str = str + stack[i] + " ";
		}
		return str + "]";
	}











}