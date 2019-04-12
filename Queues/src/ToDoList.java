public class ToDoList {

	public static void main(String[] args) {

		PQueue<Task> toDoList = new PQueue<Task>();
		
		toDoList.enqueue( new Task( "Go to the movies", 'B', 1));
		toDoList.enqueue( new Task( "Do homework", 'C', 1));
		toDoList.enqueue( new Task( "Do the dishes", 'B', 2));
		toDoList.enqueue( new Task( "Play video games", 'A', 1));
		toDoList.enqueue( new Task( "Program", 'C', 3));
		toDoList.enqueue( new Task( "Solve a puzzle", 'C', 2));

		while( !toDoList.isEmpty())
				System.out.println( toDoList.dequeue());
		
		

	}

}