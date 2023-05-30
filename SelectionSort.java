public class SelectionSort {
	
	public static void main(String args[])
	{
		int arr[]=new int[] {1,34,2,45,67,89};
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				int temp;
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;	
				}	
			}
				
		}
		
		for(int j=0;j<arr.length;j++)
		{
			System.out.println(arr[j]);
		}
	}

}
