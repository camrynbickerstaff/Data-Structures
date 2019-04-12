import javax.swing.JOptionPane;

public class RandomNumber {
	public static void main(String[] args)
	{
		int playAgain = 1;
		while(playAgain == 1)
		{
			int goAgain = 0;
			int num1 = 0;
			int num = 0;
			while(num1 < 1 || num1 > 100)
			{
				num1 = Integer.parseInt(JOptionPane.showInputDialog("Highest Number for guessing number. Choose a number between 1 and 100"));
				num = (int) (Math.random()*(num1)+1);
			}
			int guess = -1;
		    while(goAgain < 10 && guess != num)
			{
		    	if(goAgain == 0)
		    	{
		    		guess = Integer.parseInt(JOptionPane.showInputDialog("There is a number between 1 and " + num1 + " what is your guess?"));
		    		if(guess == num)
		    		{
		    			goAgain = 11;
		    			JOptionPane.showMessageDialog(null, "You guessed the number! Congrats");
		    		}
		    		else
		    		{
		    			if(guess > num)
		    			{
		    				JOptionPane.showMessageDialog(null, "Your guess was too high!");
		    			}
		    			if(guess < num)
		    			{
		    				JOptionPane.showMessageDialog(null, "Your guess was too low!");
		    			}
		    		}
		    	}
		    	else
		    	{
		    		guess = Integer.parseInt(JOptionPane.showInputDialog("What is your next guess between 1 and " + num + "?"));
		    		if(guess == num)
		    		{
		    			goAgain = 11;
		    			JOptionPane.showMessageDialog(null, "You guessed the number! Congrats");
		    		}
		    		else
		    		{
		    			if(guess > num)
		    			{
		    				JOptionPane.showMessageDialog(null, "Your guess was too high!");
		    			}
		    			if(guess < num)
		    			{
		    				JOptionPane.showMessageDialog(null, "Your guess was too low!");
		    			}
		    		}
		    	}
		    	goAgain++;
			}
		    if(goAgain >= 10 && guess != num)
		    {
		    	JOptionPane.showMessageDialog(null, "The random number was " +num);
		    	
		    }
		    playAgain = guess = Integer.parseInt(JOptionPane.showInputDialog("Do you want to play again? Enter a 1 for yes or 0 for no"));

		}
	}

}