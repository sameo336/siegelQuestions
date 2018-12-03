package siegelQuestions;

public class Vertex 
{
	Integer pre;
	Integer post;
	char vertexName;
	
	Vertex()
	{
		pre =-1;
		post =-1;
	}
	
	@Override
	public String toString()
	{
		return Character.toString(this.vertexName);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Vertex))
		{
			return false;
		}
		Vertex check = (Vertex)o;
		if(check.vertexName == this.vertexName)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public int hashCode() 
	{
		char name = this.vertexName;
		return name;
		
	}
	
	
	public static void main(String args[]) 
	{
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();
		
		v1.vertexName = 'v';
		v2.vertexName = 'v';
		
		
		System.out.println(v1.equals(v2));
		System.out.println(v1.hashCode());
		System.out.println(v2.hashCode());


	}
}