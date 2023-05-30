#include<iostream>
using namespace std;

int isVisited(int arr[], int visited, int j)
{
	for(int i = 0;i <= visited;i++)
	{
		if(arr[i] == j)
		{
			return 0;
		}
	}
	return 1;
}

int main()
{
	int vertex = 7;
	int graph[][7] = {
		{0,20,0,30,0,0,40},
		{20,0,30,0,20,0,0},
		{0,30,0,0,0,0,0},
		{30,0,0,0,50,0,0},
		{0,20,0,50,0,70,60},
		{0,0,0,0,70,0,0},
		{40,0,0,0,60,0,0}		
	};
	
	
	for(int i = 0;i < 7;i++)
	{
		for(int j = 0;j < 7;j++)
		{
			cout<<graph[i][j]<<" ";
		}
		cout<<endl;
	}

	int arr[vertex];
	int visited = 0, cost = 0;
	arr[0] = visited;
	
	while(visited != vertex)
	{
		int min = 500;
		int minIndex = 0;
		for(int i = 0;i <= visited;i++)
		{
			for(int j = 0;j < vertex;j++)
			{	
				if(min > graph[arr[i]][j] && graph[arr[i]][j] != 0 && isVisited(arr, visited, j))
				{
					min = graph[arr[i]][j];
					minIndex = j;
				}
			}
		}
		
		visited++;
		arr[visited] = minIndex;
		cost = cost + min;
	}	
	
	cout<<"Minimal Cost is "<<cost - 500;
}