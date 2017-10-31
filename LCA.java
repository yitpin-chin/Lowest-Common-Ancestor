import java.util.*;

  public class LCA<T> {
	
	  Node_DAG root;
	  
	  List<Node_DAG<T>> DFS(List<Node_DAG<T>> list, Stack<Node_DAG<T>> stack, Node_DAG<T> node, Node_DAG<T> searchNode){
		  
		  stack.push(node);
		  
		  for(Node_DAG<T> n : node.point){
			  
			  if(n.equals(searchNode)){
				  
				  list.addAll(stack);
				  return list;
			  }
			  
			  DFS(list, stack, node, searchNode);
		  }
		  
		  stack.pop();
		  return list;
	  }
	  
	  public Node_DAG<T> LCA(Node_DAG<T> root, Node_DAG<T> n1, Node_DAG<T> n2){
		  
		  List<Node_DAG<T>> list1 = DFS(new ArrayList<>(), new Stack<>(), root, n1);
		  List<Node_DAG<T>> list2 = DFS(new ArrayList<>(), new Stack<>(), root, n2);
		  List<Node_DAG<T>> minList;
		  List<Node_DAG<T>> maxList;
		  
		  if(root == null || n1 == null || n2 == null){
			  
			  return null;
		  }
		  
		  if(list1 == null || list2 == null){
			  
			  return null;
		  }
		  
		  
	  }

	
}
