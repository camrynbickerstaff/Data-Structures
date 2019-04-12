import java.util.Random;
import java.util.Scanner;

public class SimpleAdditionProblems 
{
	public static void main(String[] args) {
			
			int operand1;
			int operand2;
			int studentAnswer;
			int correctAnswers = 0;
			int incorrectAnswers = 0;
			Random rand = new Random();
			final int MAX_PROBLEMS = 5;
			ABQueue<AdditionProblem> queue = new ABQueue<AdditionProblem>(MAX_PROBLEMS);
			Scanner keyboard = new Scanner( System.in);
			
			System.out.println("I am going to give you " + MAX_PROBLEMS + " simple addition problems.\nI will display a problem. You need to type the answer.");
			for( int count = 1 ; count <= MAX_PROBLEMS ; count++)
			{
				operand1=  rand.nextInt(10);
				operand2 = rand.nextInt(10);
				AdditionProblem problem = new AdditionProblem(operand1, operand2);
				System.out.print(problem);
				studentAnswer = keyboard.nextInt();
				if(studentAnswer == problem.getAnswer())
				{
					correctAnswers++;
					System.out.println("This is correct!");
				}
				else
				{
					incorrectAnswers++;
					System.out.println("This is incorrect. You will see this problem again shortly.");
					queue.enqueue(problem);
				}
			}
			System.out.println("You got " + correctAnswers+ " problems right and " + incorrectAnswers + " problems wrong");

			if(!queue.isEmpty())
			{
				System.out.println("Next, you will have a second chance to solve the problems you missed.");
				while(!queue.isEmpty())
				{
					AdditionProblem problem;
					problem = queue.dequeue();
					System.out.print(problem);
					studentAnswer = keyboard.nextInt();
					if(studentAnswer == problem.getAnswer())
					{
						correctAnswers++;
						System.out.println("This is correct!");
					}
					else
					{
						incorrectAnswers++;
						System.out.println("This is incorrect. The correct answer is " + problem.getAnswer());
					}
				}
			}
			
			System.out.println( "Done.");
			keyboard.close();
			return;
		}
}