package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Shortestpath_impl 
{
	static Shortestpath_impl obj = new Shortestpath_impl();
	static djikstras obj1 = new djikstras();
	public static void main(String[] args) throws Exception 
	{
		
		int matrix[][]=null;
		System.out.println("-----------------------------");
		System.out.println("User Driven Menu : Choose 1-4");
		System.out.println("1 - Import file");
		System.out.println("2 - Compute Routing Table");
		System.out.println("3 - Shortest Route + Cost");
		System.out.println("4 - End Program");
		System.out.println("------------------------------");
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
        
		while(input!=4)
		{
		switch (input)
		   {
			case 1:
				matrix = obj.importFile();
				display(matrix);
				break;
			case 2:
				obj.compute_Table(matrix);
				break;
			case 3:
				obj.dijkstra_1(matrix);
				break;
			 
				 
			default:System.out.println("Invalid input please try again");
			}
		System.out.println("-----------------------------");
		System.out.println("User Driven Menu : Choose 1-4");
		System.out.println("1. Import file");
		System.out.println("2. Compute Routing Table");
		System.out.println("3. Shortest Route + Cost");
		System.out.println("4 . End");
		System.out.println("------------------------------");
			input = sc.nextInt();
		}
		System.out.println("Thank you for using my program");
	}
	
	public static void dijkstra_1 (int matrix[][]) throws IOException
	{
		System.out.println("Enter the source and the destination routers");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] arr = line.split(" ");
		int src = Integer.parseInt(arr[0]) - 1;
		int dest = Integer.parseInt(arr[1]) - 1;
		obj1.dijkstra(matrix,src,dest,2);
	}
	public static void compute_Table(int matrix[][])
	{
		System.out.println("Enter the router whose routing table you want");
		Scanner sc = new Scanner(System.in);
		int rlen = matrix.length;
		//System.out.println(rlen);
		int in =sc.nextInt();
		int v = in -1;
		Object arr[][]=new Object[1][3];
		System.out.println("The routing table for router "+in +":-");
		System.out.println("Source   | Destination  |  Next hop");
		System.out.println("");
		try{
			for(int i=0; i<=rlen; i++)
				{
				if(i==(in-1))
				  { 
					i++;
				  }
				   
					arr[0][0]="Router "+(in);
					arr[0][1]="|   Router "+(i+1);
					
					arr[0][2]= obj1.dijkstra(matrix,in-1,i,1);
				
	
					display1(arr);
					
				}
	           
			System.out.println("");
			
		}
		catch(Exception e)
		{
			System.out.println();
		}
	}
		
	

	public static void display1(Object arr[][])
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
		
	

	public static int[][] importFile() throws IOException 
	{
		
		int row = 0 , column =0;
		String line[]=null;
		System.out.println("Make Sure the txt file is present in the directory");
		System.out.println("Enter file name-->");
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
	    BufferedReader br =  new BufferedReader(new FileReader(st));
		
		String rowText ;
		System.out.println("The input matrix is ");
		
			while ((rowText= br.readLine()) != null)
			{
				row++;
				line = rowText.split(" ");
				column= line.length;
				
			}
			int matrix[][]= new int[row][column];
		br.close();
		//System.out.println(column);
		
		return store(st,column);
		
		
	}
	public static int[][] store(String s,int column) throws NumberFormatException, IOException
	{
		int temp=0;
		  String rowText1;
		  int matrix[][] = new int[column][column];
			BufferedReader br1= new BufferedReader(new FileReader(s));
		
			while ((rowText1 = br1.readLine()) != null)
			{
				String line[] = rowText1.split(" ");

				for (int i = 0; i < column; i++) 
				{
					matrix[temp][i] = Integer.parseInt(line[i]);
				}
				temp++;
			}
		
		
			br1.close();
		    
			return matrix;	
		
	}
    
	public static void display(int x[][])
	{
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<x.length;j++)
			{
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
}
