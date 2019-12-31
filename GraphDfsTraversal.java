package siegelQuestions;

import java.util.*;

public class GraphDfsTraversal
{
	static Map <Vertex, ArrayList<Vertex> > adjacency_list;
	static Integer preid;
	static Integer postid;
	
	GraphDfsTraversal()
	{
		preid =1;
		postid=1;
	}
	
	public static void main(String args[])
	{
		GraphDfsTraversal graph = new GraphDfsTraversal();
		graph.adjacency_list = new HashMap <Vertex, ArrayList<Vertex>>();
		Vertex a = new Vertex();
		a.vertexName ='a';
		Vertex b = new Vertex();
		b.vertexName ='b';
		Vertex c = new Vertex();
		c.vertexName ='c';
		Vertex d = new Vertex();
		d.vertexName ='d';
		ArrayList <Vertex> a1=  new ArrayList<Vertex>();
		ArrayList <Vertex> b1=  new ArrayList<Vertex>();
		ArrayList <Vertex> c1=  new ArrayList<Vertex>();
		ArrayList <Vertex> d1=  new ArrayList<Vertex>();
		a1.add(c);
		a1.add(b);
		b1.add(c);
		b1.add(a);
		b1.add(d);
		c1.add(b);
		c1.add(d);
		d1.add(b);
		d1.add(c);
		adjacency_list.put(a,a1);
		adjacency_list.put(b,b1);
		adjacency_list.put(c,c1);
		adjacency_list.put(d,d1);

		System.out.println("EXIT!");
		graph.dfs_graph(a);
	}
	public void dfs_graph(Vertex v)
	{
		v.pre = preid;
		preid = preid+1;
		System.out.println("first " + v.vertexName);
		System.out.println(v.vertexName + " pre:" + v.pre);

		
		ArrayList <Vertex> adjList = adjacency_list.get(v);
		for (Vertex w : adjList)
		{
			if (w.pre ==-1)
			{
				System.out.println("Traversing from: " 
			+ v.vertexName + "  to "+ w.vertexName);
				dfs_graph(w);
			}
		}
		
		v.post = postid;
		postid = postid +1;
		System.out.println(v.vertexName + " post:" + v.post);
	
	}
	
	
}
