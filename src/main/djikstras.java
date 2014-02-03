package main;
public class djikstras
{

	public static Object dijkstra(int[][] matrix, int src , int dest ,int choice)
	{
		int index = src;
		int counter =0 ;int[] path_length = matrix[src].clone();
		boolean[] tof = new boolean[matrix[0].length];
		int[] N = new int[matrix[0].length];
		N[counter] = index;
		int[] pIndex = new int[matrix[0].length];
		for (int i = 0; i < pIndex.length; i++) 
		{
			pIndex[i] = src;
		}
		tof[index] = true;
		while (counter < matrix[0].length) 
		{
			
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < path_length.length; i++) {
				if (!tof[i] && path_length[i] != -1 && i != index) {
			
					if (path_length[i] < min) {
						min = path_length[i];
						index = i;
					}
				}
			}
			if (index == dest) 
			{
				break;
			}
			tof[index] = true;
			counter++;
			N[counter] = index;
			
			for (int i = 0; i < path_length.length; i++) {
				
				if (path_length[i] == -1 && matrix[index][i] != -1 && ! tof[i]) 
				{
					path_length[i] = path_length[index] + matrix[index][i];
					pIndex[i] = index;
				}
				else if (matrix[index][i] != -1 && path_length[index] + matrix[index][i] < path_length[i])
				{
					
					path_length[i] = path_length[index] + matrix[index][i];
					pIndex[i] = index;
				}
			}
		}
		if(choice ==2 )
		{
		System.out.print("Shortest route from " + (src + 1) + " to " + (dest + 1) + " is --> ");
		display_LeastCost(pIndex, src, dest, path_length.length);
		System.out.println();
		System.out.println(" . The total cost is "+ (path_length[dest] - path_length[src]) + ".");

		return path_length[dest];
		}
		if(choice ==1 )
			return nextHop(pIndex, src, dest, path_length.length);
		else return null;
		
	}
public static String nextHop(int[] pIndex, int src, int dest, int len)
{
	int[] route = new int[len];
	int i = dest;
	route[0] = i;
	int k = 1;
	while (pIndex[i] != src)
	{
		i = pIndex[i];
		route[k] = i;
		k++;
	}
	route[k] = src;
	int h=0;
	for (int j = k; j > 0; j--)
	{
		
		h++;
		if(h==2)
			return "   | Router"+(route[j]+1);
	}

	 if (h==1)
		{
		return "   | NA ( Direct )";
		}
	 return null;
}
	
	public static void display_LeastCost(int[] pIndex, int src, int dest, int len)
	{
		int[] path = new int[len];
		int i = dest;
		path[0] = i;
		int k = 1;
		while (pIndex[i] != src) 
		{
			i = pIndex[i];
			path[k] = i;
			k++;
		}
		path[k] = src;
		//int h=0;
		for (int j = k; j > 0; j--)
		{
			System.out.print("Router " + (path[j] + 1) + " to ");
			//h++;
		}
		System.out.print("Router " + (path[0] + 1)) ;
	}
}
