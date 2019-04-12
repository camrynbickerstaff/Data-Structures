import java.util.Random;
public class MergingLists 
{
	public static void main(String[] args)
	{
		int[] A = new int[25];
		int[] B = new int[40];
		ABList<Integer> C = new ABList<Integer>();
		Random random = new Random();
		int i,j;
		
		for(i = 0; i < A.length; i++)
		{
			A[i] = random.nextInt(100);	
		}
		for(j = 0; j < B.length; j++)
		{
			B[j] = random.nextInt(100);
		}
		
		A = bubbleSort(A);
		B = bubbleSort(B);
		for(int p = 0; p < A.length; p++)
		{
			System.out.print(A[p] + " ");
		}
		System.out.println();
		for(int p = 0; p < B.length; p++)
		{
			System.out.print(B[p] + " ");
		}
		System.out.println();
		i = j = 0;
		while(i < A.length && j < B.length)
		{
			//System.out.println(C);
			if(A[i] <= B[j])
			{
				C.insert(A[i]);
				i++;
			}
			else
			{
				C.insert(B[j]);
				j++;
			}
			
		}
		
		while(i < A.length)
		{
			C.insert(A[i++]);
		}
		while(j < B.length)
		{
			C.insert(B[j++]);
		}

		System.out.println(C);
	}

	public static int[] bubbleSort(int[] x)
	{
		int pass,i,swap;
		
		for(pass = 1; pass < x.length; pass++)
		{
			for(i = 0; i < x.length-1; i++)
			{
				if(x[i] > x[i+1])
				{
					swap = x[i];
					x[i] = x[i+1];
					x[i+1] = swap;
				}
			}
		}
	/*	for(int j = 0; j < x.length; j++)
		{
			System.out.print(x[j] + " ");
		}*/
		return x;
	}
}