import java.util.*;

public class Node_DAG<T> {

	Set<Node_DAG<T>> point;
	T data;
	
	public Node_DAG(T data){
		
		this.data = data;
		this.point = new HashSet<>();
	}
	
	public void addEdge(Node_DAG<T> edge){
		
		point.add(edge);
	}
	
}
