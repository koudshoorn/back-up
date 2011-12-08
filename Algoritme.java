import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Algoritme {
	
	public static void main(String[] args)
	{
		String filename;
		Algoritme a = new Algoritme();
		if(args.length == 1)
		{
			filename = args[0];
			try{
				File file = new File(filename);
				Scanner sc = new Scanner(file);
				
				
					
					
			}catch(Exception e){System.out.println(e);}
		} else {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int[] rt = new int[n];
			for(int i = 0; i < n; i++)
			{
				rt[i] = s.nextInt();
			}
			a.divideTrainsAmongDepots(n, rt);
		}
		
		
	}
	
	public void divideTrainsAmongDepots(int n, int[] rt)
	{
		int TRT = 0;
		for(int j = 0; j < n; j++ )
		{
			TRT = TRT + rt[j];
		}
		int HTRT = TRT / 2; 
		
		int[][] M = new int[n+1][HTRT + 1];
		
		for(int i = 0; i <= n; i++)
		{
			for(int trt = 1; trt <= HTRT; trt++)
			{
				if(i == 0)
				{
					M[i][trt] = 0;
				}else if(rt[i-1] > trt)
				{
					M[i][trt] = M[i-1][trt];
				} else {
					M[i][trt] = max(rt[i-1] + M[i-1][trt - rt[i-1]], M[i-1][trt]);
				}
			}
		}
		System.out.println(TRT - 2 * M[n - 1][HTRT]);
	}
	
	public int max(int x, int y)
	{
		if(x >= y)
			return x;
		else
			return y;
	}
}
