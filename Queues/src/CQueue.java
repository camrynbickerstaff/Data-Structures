public class CQueue<T> {
	private int back;
	private int front;
	private int size;
	private T [] queue;
	
	public CQueue() {
		
		back = 0;
		front = 0;
		size = 0;
		queue = (T[]) new Object[10];
	}
	
	public CQueue( int capacity) {
		
		back = 0;
		front = 0;
		size = 0;
		if( capacity > 0)
			queue = (T[]) new Object[capacity];
		else
			queue = (T[]) new Object[1000];
	}
	public void enqueue( T element) {
		
		if( isFull()) 
		{
			T[] newQueue = (T[]) new Object[queue.length+50];
			for(int i = 0; i < queue.length; i++)
			{
				newQueue[i] = queue[i];
				//System.out.println("hey");
			}
			back = queue.length;
			queue = newQueue;
			
		}
		
		queue[back] = element;
		back = (back+1)%queue.length;
		size++;

		
	}
	
	public T dequeue() 
	{
		T item = null;
		if( isEmpty()) 
		{
			System.out.println( "Empty queue...");
			return item;
		}
		
		item = queue[front];
		
		front = (front+1)%queue.length;
		size--;
		return item;
	}

	public T peekAtFront() {
		
		T frontItem = null;
		if(!isEmpty()) 
		{
			frontItem = queue[front];	
		}
		else
		{
			System.out.println("Queue is Empty");
		}
		
		
		return frontItem;
	}

	public T peekAtBack() {

		T backItem = null;
		if(isEmpty()) 
		{
			System.out.println("Queue is Empty");
		}
		if(back == 0)
		{
			backItem = queue[queue.length-1];
		}
		else
			backItem = queue[back-1];
		
		
		return backItem;
	}
	
	public String toString() {
		
		String str = "[ ";
		int x = front-1;
		if( !isEmpty())
		{
			if(front<back)
			{
				for(int index = front; index<back; index++)
				{
					str = str + queue[index] + " ";
				}
			}
			else
			{
				int index = front;
				while(index<queue.length)
				{
					str = str+ queue[index] + " ";
					index++;
				}
				for(index = 0; index < back; index++)
				{
					str = str + queue[index] + " ";
				}
				
			}

			/*for( int index = 0 ; index < size ; index++ )
			{	
				x++;
				str = str + queue[(x)%queue.length] + " ";	
			}*/
		}
		str += "]";
		
		return str;
	}

	public int size() {
		
		return( size);
	}
	
	public boolean isFull()
	{
		return( size == queue.length);
	}

	public boolean isEmpty() {
		
		return( size == 0);
	}


}