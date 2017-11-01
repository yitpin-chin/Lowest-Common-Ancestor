import java.util.*;

  public class LCA<T> {
	
	  Node_DAG<T> root;
	  
	  List<Node_DAG<T>> DFS(Node_DAG<T> node, Node_DAG<T> searchNode, List<Node_DAG<T>> list, Stack<Node_DAG<T>> stack){
		  
		  stack.push(node);
		  
		  for(Node_DAG<T> n : node.point){
			  
			  if(n.equals(searchNode)){
				  
				  list.addAll(stack);
				  return list;
			  }
			  
			  DFS(node, searchNode, list, stack);
		  }
		  
		  stack.pop();
		  return list;
	  }
	  

	  public Node_DAG<T> LCA(Node_DAG<T> node1, Node_DAG<T> node2) {

		  return LCA_DAG(root, node1, node2);
	  }
	  
	  public Node_DAG<T> LCA_DAG(Node_DAG<T> root, Node_DAG<T> node1, Node_DAG<T> node2){
		  
		  List<Node_DAG<T>> list1 = DFS(root, node1, new ArrayList<>(), new Stack<>());
		  List<Node_DAG<T>> list2 = DFS(root, node2, new ArrayList<>(), new Stack<>());
		  List<Node_DAG<T>> minList;
		  List<Node_DAG<T>> maxList;
		  
		  if(list1.size() <= list2.size()){
			  minList = list1;
			  maxList = list2;
		  }
		  else{
			  minList = list2;
			  maxList = list1;
		  }
		  
		  if(root == null || node1 == null || node2 == null){
			  
			  return null;
		  }
		  
		  if(list1 == null || list2 == null){
			  
			  return null;
		  }
		  
		  Set<Node_DAG<T>> set = new HashSet<>();
		  
		  for(Node_DAG<T> n : minList){
			  set.add(n);
		  }
		  
		  for(int j = maxList.size(); j >= 0; j--){
			  
			  if(set.contains(maxList.get(j))){
				  
				  return maxList.get(j);
			  }
		  }
		  
		  return null;
		  
	  }

}
