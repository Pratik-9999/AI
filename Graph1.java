import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;

public class Graph1 {
	
    public LinkedList<Integer>[] adj;
    
    public int ver;
    public int edge;
    
    Graph1(int ver,int edge)
    {
    	this.ver=ver;
    	this.edge=edge;
    	
    	adj=new LinkedList[ver];
    for(int i=0;i<adj.length;i++)
    	adj[i]=new LinkedList<Integer>();
    	
    	
    }
    
    public void addEdge(int u,int v)
    {
        this.adj[u].add(v);
        this.adj[v].add(u);
    	
    }
    
    public String toString()
	{
    	StringBuilder sb=new StringBuilder();
    	sb.append(ver+"vertices"+edge+"Edges\n");
    	for(int i=0;i<ver;i++)
    	{   sb.append(i+": -> ");
    		for(int w:adj[i])
    		{
    			sb.append(w+" -> ");
    			
    		}
    		sb.append("\n");
    		
    	}
		return sb.toString();
	}
    
    
    public void dfs()
    {
    	boolean visited[]=new boolean[ver];
    	
    	for(int i=0;i<ver;i++)
    	{
    		if(!visited[i])
    		{
    			dfs(i,visited);
    			
    			
    		}
    		
    	}
    	
    }
    
    public void dfs(int v,boolean visited[])
    {
    	visited[v]=true;

    	System.out.print(v+" -> ");
		
    	for(int w:adj[v])
    	{
    		
    		if(!visited[w])
			{
				dfs(w,visited);
			}
    		
    	}
    	
    }
    public static void main(String args[])
    {   Scanner sc=new Scanner(System.in);
    	System.out.println("Enter No of Vertices In Graph\n");
    	int v=sc.nextInt();
    	System.out.println("Enter No of Edges In Graph\n");
    	int e=sc.nextInt();
    	
    	Graph1 g=new Graph1(v,e);
    	
    	for(int i=0;i<e;i++)
    	{
    		for(int j=i+1;j<v;j++)
    		{
    			System.out.println("Is there Is realation of "+i+" With "+j+" If Yes Enter 1 otherwiase 0");
    			int ans=sc.nextInt();
    			if(ans==1)
    				g.addEdge(i,j);
    			
    		}
    		
    	}
    	System.out.println("\nAdjacency List Presntation of graph is Follows "+g);
    	g.dfs();
    	
    	
    }
	
	
}
