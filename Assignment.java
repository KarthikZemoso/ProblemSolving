import java.util.*;
public class Assignment {
	    int V;
	    ArrayList<ArrayList<Integer> > adj;
	    Assignment(int v)
	    {
	        V = v;
	        adj = new ArrayList<ArrayList<Integer> >(v);
	        for (int i = 0; i < v; ++i)
	            adj.add(new ArrayList<Integer>());
	    }
	 
	    void addEdge(int v, int w) { adj.get(v).add(w); }
	 
	    void SortUtil(int v, boolean visited[], Stack<Integer> stack)
	    {
	        visited[v] = true;
	        Integer i;
	        Iterator<Integer> it = adj.get(v).iterator();
	      //  System.out.println(v);
	        while (it.hasNext()) {
	        	
	            i = it.next();
	         //   System.out.print(i);
	            
	            if (!visited[i])
	                SortUtil(i, visited, stack);
	        }
	      //  System.out.println();
	        stack.push(new Integer(v));
	    }

	    void Sort()
	    {
	        Stack<Integer> stack = new Stack<Integer>();
	        boolean visited[] = new boolean[V];
	        for (int i = 0; i < V; i++)
	            visited[i] = false;
	        for (int i = 0; i < V; i++)
	            if (visited[i] == false)
	                SortUtil(i, visited, stack);
	        while (stack.empty() == false)
	            System.out.print(stack.pop() + " ");
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Assignment a =new Assignment(n);
		for(int i=0;i<n;i++) {
			int v=sc.nextInt();
			int e=sc.nextInt();
			a.addEdge(v, e);
		}
        a.Sort();

	}

}
