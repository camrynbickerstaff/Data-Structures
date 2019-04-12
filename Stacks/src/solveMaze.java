public class solveMaze {
	

	public static void main(String[] args) throws Exception 
	{
		Maze maze = mazeGenerator();
		System.out.println("Here is the maze: ");
		for(int i = 0; i < maze.maze.length; i++)
		{
			for(int j = 0; j<maze.maze.length; j++)
			{
				System.out.print(maze.maze[i][j] + " ");
			}
			System.out.println();
		}
		Thread.sleep(5000);
		mazeTraverse(maze);
		
	}
	public static Maze mazeGenerator() throws Exception
	{
		int m = (int)(Math.random()*(35-10+1) +15);
		//int m = 40;
		int end = -1;
		if(m%2 == 0)
		{
			m = m-1;
		}
		String[][] maze = new String[m][m];
		int start = (int)(Math.random()*(m-2) +1);
		if((start%2 == 0))
		{
			start = start + 1;
		}

		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j<m; j++)
			{
				maze[i][j] = " ";
			}
		}
		for(int i = 0; i< m; i++)
		{
			maze[i][0] = "#";
			maze[i][m-1] = "#";
			maze[0][i] = "#";
			maze[m-1][i] = "#";
		}

		for(int i = 2; i < m; i = i + 2)
		{
			for(int j = 0; j< m; j++)
			{
				maze[i][j] = "#";
				maze[j][i] = "#";
			}
			
		}
		/*for(int i = 0; i < m; i++)
		{
			for(int j = 0; j<m; j++)
			{
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}*/
		Thread.sleep(10000);
		maze[start][0] = ".";
		maze[start][1] = ".";
		
		int nextSpot;
		int currentRow = start;
		int currentColumn = 1;
		while(currentColumn != m-1)
		{
			nextSpot = (int)(Math.random()*(10) +1);
			
			if(nextSpot <5 && currentRow > 1 && currentColumn > 0 )
			{
				if(maze[currentRow-1][currentColumn].contentEquals("#") && maze[currentRow-2][currentColumn].contentEquals(" "))
				{
					maze[currentRow-1][currentColumn] = ".";
					maze[currentRow-2][currentColumn] = ".";
					currentRow = currentRow - 2;
				}
				
			}
			else if(nextSpot >8 && currentColumn < m-1)
			{
				if(currentColumn == m-2)
				{
					currentColumn = currentColumn + 1;
					maze[currentRow][currentColumn] = ".";
				}
				else if(maze[currentRow][currentColumn+1].contentEquals("#") && maze[currentRow][currentColumn+2].contentEquals(" "))
				{
					
					maze[currentRow][currentColumn+1] = ".";
					maze[currentRow][currentColumn+2] = ".";
					currentColumn = currentColumn + 2;
				}
			}
			else if((nextSpot >= 5 || nextSpot <=8) && currentRow < m-2 && currentColumn > 0 )
			{
				if(maze[currentRow+1][currentColumn].contentEquals("#") && maze[currentRow+2][currentColumn].contentEquals(" ") )
				{
					maze[currentRow+1][currentColumn] = ".";
					maze[currentRow+2][currentColumn] = ".";
					currentRow = currentRow + 2;
				}
			}
			end = currentRow;
	
		}
	/*	for(int i = 0; i < m; i++)
		{
			for(int j = 0; j<m; j++)
			{
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}*/
		//Thread.sleep(10000);
		int delete;
		for(int i = 1; i< m-1; i++)
		{
			for(int j = 1; j<m-1; j++)
			{
				if(maze[i][j].contentEquals(" ") && maze[i-1][j].contentEquals("#") && maze[i][j+1].contentEquals("#") && maze[i][j-1].contentEquals("#") && maze[i+1][j].contentEquals("#"))
				{
					if(i == 1)
					{
						if(j == 1)
						{
							delete = (int)(Math.random()*(2-1+1) +1);
							if(delete == 1)
							{
								maze[i][j] = ".";
								maze[i][j+1] = ".";
								maze[i][j+2] = ".";
								maze[i][j+3] = ".";
								maze[i+1][j] = ".";
							}
							else if(delete == 2)
							{
								maze[i][j] = ".";
								maze[i+1][j] = ".";
								maze[i+2][j] = ".";
								maze[i+3][j] = ".";
								maze[i][j+1] = ".";
										
							}
						}
						else if(j == m-2)
						{
							delete = (int)(Math.random()*(2-1+1) +1);
							if(delete == 1)
							{
								maze[i][j] = ".";
								maze[i][j-1] = ".";
								maze[i][j-2] = ".";
								maze[i][j-3] = ".";
								maze[i+1][j] = ".";
							}
							else if(delete == 2)
							{
								maze[i][j] = ".";
								maze[i+1][j] = ".";
								maze[i+2][j] = ".";
								maze[i+3][j] = ".";
								maze[i][j-1] = ".";
										
							}
						}
						else
						{
							delete = (int)(Math.random()*(3-1+1) +1);
							if(delete == 1)
							{
								maze[i][j] = ".";
								maze[i][j-1] = ".";
								maze[i][j-2] = ".";
								maze[i+1][j] = ".";
							}
							else if(delete == 2)
							{
								maze[i][j] = ".";
								maze[i+1][j] = ".";
								maze[i+2][j] = ".";
								maze[i][j-1] = ".";
										
							}
							else if(delete == 3)
							{
								maze[i][j] = ".";
								maze[i][j+1] = ".";
								maze[i][j+2] = ".";
								maze[i+1][j] = ".";
							}
						}
					}
					else if(i == m-2)
					{
						if(j == 1)
						{
							delete = (int)(Math.random()*(2-1+1) +1);
							if(delete == 1)
							{
								maze[i][j] = ".";
								maze[i-1][j] = ".";
								maze[i-2][j] = ".";
								maze[i-3][j] = ".";
								maze[i][j+1] = ".";
							}
							else if(delete == 2)
							{
								maze[i][j] = ".";
								maze[i][j+1] = ".";
								maze[i][j+2] = ".";
								maze[i][j+3] = ".";
								maze[i-1][j] = ".";
										
							}
						}
						else if(j == m-2)
						{
							delete = (int)(Math.random()*(2-1+1) +1);
							if(delete == 1)
							{
								maze[i][j] = ".";
								maze[i][j-1] = ".";
								maze[i][j-2] = ".";
								maze[i][j-3] = ".";
								maze[i-1][j] = ".";
							}
							else if(delete == 2)
							{
								maze[i][j] = ".";
								maze[i-1][j] = ".";
								maze[i-2][j] = ".";
								maze[i-3][j] = ".";
								maze[i][j-1] = ".";
										
							}
						}
						else
						{
							delete = (int)(Math.random()*(2-1+1) +1);
							if(delete == 1)
							{
								maze[i][j] = ".";
								maze[i][j-1] = ".";
								maze[i][j-2] = ".";
								maze[i][j+1] = ".";
								maze[i][j+2] = ".";
							}
							else if(delete == 2)
							{
								maze[i][j] = ".";
								maze[i-1][j] = ".";
								maze[i-2][j] = ".";
										
							}
			
						}
					}
					else if(j == 1)
					{
						delete = (int)(Math.random()*(2-1+1) +1);
						if(delete == 1)
						{
							maze[i][j] = ".";
							maze[i][j+1] = ".";
							maze[i][j+2] = ".";
						}
						else if(delete == 2)
						{
							maze[i][j] = ".";
							maze[i+1][j] = ".";
							maze[i+2][j] = ".";
							maze[i-1][j] = ".";
							maze[i-2][j] = ".";
									
						}

					}
					else if(j == m-2)
					{
						delete = (int)(Math.random()*(2-1+1) +1);
						if(delete == 1)
						{
							maze[i][j] = ".";
							maze[i][j-1] = ".";
							maze[i][j-2] = ".";
							
						}
						else if(delete == 2)
						{
							maze[i][j] = ".";
							maze[i+1][j] = ".";
							maze[i+2][j] = ".";
							maze[i-1][j] = ".";
							maze[i-2][j] = ".";
									
						}
				
					}
					else
					{
						delete = (int)(Math.random()*(2-1+1) +1);
						if(delete == 1)
						{
							maze[i][j] = ".";
							maze[i][j+1] = ".";
							maze[i][j+2] = ".";
							maze[i][j-1] = ".";
							maze[i][j-2] = ".";
							
						}
						else if(delete == 2)
						{
							maze[i][j] = ".";
							maze[i+1][j] = ".";
							maze[i+2][j] = ".";
							maze[i-1][j] = ".";
							maze[i-2][j] = ".";
									
						}
			
					}
				}
			}
		/*	for(int p = 0; p < m; p++)
			{
				for(int q = 0; q<m; q++)
				{
					System.out.print(maze[p][q] + " ");
				}
				System.out.println();
			}
			Thread.sleep(10000);*/
		}
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j<m; j++)
			{
				if(maze[i][j].contentEquals(" "))
				{
					maze[i][j] = ".";
				}
			}

		}
	
		Spot start1 = new Spot(start,0);
		Spot end1 = new Spot(m-1,end);	
		
		return new Maze(start1,end1,maze);
	}
	
	
	
	public static void mazeTraverse(Maze maze) throws Exception
	{
		int start = maze.start.row;
		int end = maze.end.row;
		String[][] mazer = maze.maze;
		int i = start;
		int j = 0;
		int q = 0;
		LinkedStack<Spot> path = new LinkedStack<Spot>();
		while(i != end && j != mazer.length)
		{
			for(int n = 1; n< (mazer.length*mazer.length); n++)
			{
				System.out.println("\n");
			}
			if(mazer[i][j].contentEquals(".") || mazer[i][j].contentEquals("X"))
			{
				mazer[i][j] = "X";
				if( j == mazer.length-1 || mazer[i][j+1].contentEquals("."))
				{
					path.push(new Spot(i,j));
					j++;
					q = 1;
				}
				else if(mazer[i+1][j].contentEquals("."))
				{
					path.push(new Spot(i,j));
					i++;
					q = 1;
				}

				else if(mazer[i-1][j].contentEquals("."))
				{
					path.push(new Spot(i,j));
					i--;
					q = 1;
				}
				else if(mazer[i][j-1].contentEquals("."))
				{
					path.push(new Spot(i,j));
					j--;
					q = 1;
				}
				else
				{
					Spot back = path.pop();
					i = back.row;
					j = back.column;
					q = 2;
				}
				
				for(int k = 0; k < mazer.length; k++)
				{
					for(int l = 0; l<mazer.length; l++)
					{
						System.out.print(mazer[k][l] + " ");
					}
					System.out.println();
				}
				if(q == 1)
				{
					Thread.sleep(500);
				}
				
			}
			
		}
		while(!path.isEmpty())
		{
			Spot back = path.pop();
			i = back.row;
			j = back.column;
			mazer[i][j] = "O";
		}
		for( int t = 0; t < 50; t++)
		{
			System.out.println();
		}
		System.out.println("Here is the solution to the maze: ");
		for(int k = 0; k < mazer.length; k++)
		{
			for(int l = 0; l<mazer.length; l++)
			{
				System.out.print(mazer[k][l] + " ");
			}
			System.out.println();
		}
	
	}
	private static class Spot
	{
		protected int row;
		protected int column;

		public Spot(int row, int column)
		{
			this.row = row;
			this.column = column;;
		}

	}
	private static class Maze
	{
		protected Spot start;
		protected Spot end;
		protected String[][] maze;
		
		public Maze(Spot start, Spot end, String[][] maze)
		{
			this.start = start;
			this.end = end;
			this.maze = maze;
		}
		
	}
	
}
