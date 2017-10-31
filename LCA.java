import java.util.*;

  public class LCA<T> {
	
	  Node_DAG root;
	  
	  List<Node_DAG<T>> DFS(List<Node_DAG<T>> list, Node_DAG<T> node, Node_DAG<T> searchNode, Stack<Node_DAG<T>> stack){
		  
		  stack.push(node);
		  
		  for(Node_DAG<T> n : node.point){
			  
			  if(n.equals(searchNode)){
				  
				  list.addAll(stack);
				  return list;
			  }
			  
			  DFS(list, node, searchNode, stack);
		  }
		  
		  stack.pop();
		  return list;
	  }

	
}
