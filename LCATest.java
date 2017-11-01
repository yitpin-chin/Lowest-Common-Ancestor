import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class LCATest {

	@Test
	public void testConstructor(){
		
		/**
		 * 					1
		 * 				/		\
		 * 			2				3
		 * 		 /	   \		/ 	   \
		 * 		4		5		6		7
		 * 
		 * index:	0 1 2 3 4 5 6
		 * number:	1 2 3 4 5 6 7
		 */
		
		LCA<Integer> testDAG = new LCA<>();
		ArrayList<Node_DAG<Integer>> testDAGList = new ArrayList<>();
		
		for(int i=0; i<7; i++){
			
			testDAGList.add(new Node_DAG<Integer>(i));
		}
		
		testDAG.root = testDAGList.get(0); //root = 1
		
		assertNotNull("Testing DAG not null after adding root:", testDAG);
	}
	
	@Test
	public void testEmptyTree(){
		
		LCA<Integer> testDAG = new LCA<>();
		ArrayList<Node_DAG<Integer>> testDAGList = new ArrayList<>();
		
		for(int i=0; i<7; i++){
			
			testDAGList.add(new Node_DAG<Integer>(i));
		}
		
		assertNull("Trying to find LCA of empty tree. Should give null", testDAG.LCA(testDAGList.get(5), testDAGList.get(6)));
	}
	
	@Test
	public void testCommonAncestor(){
		
		/**
		 * 					1
		 * 				/		\
		 * 			2				3
		 * 		 /	   \		/ 	   \
		 * 		4		5		6		7
		 * 
		 * index:	0 1 2 3 4 5 6
		 * number:	1 2 3 4 5 6 7
		 */
		
		LCA<Integer> testDAG = new LCA<>();
		ArrayList<Node_DAG<Integer>> testDAGList = new ArrayList<>();
		
		for(int i=0; i<7; i++){
			
			testDAGList.add(new Node_DAG<Integer>(i));
		}
		
		testDAG.root = testDAGList.get(0); //root = 1
		testDAGList.get(0).addEdge(testDAGList.get(1));
		testDAGList.get(0).addEdge(testDAGList.get(2));
		testDAGList.get(1).addEdge(testDAGList.get(3));
		testDAGList.get(1).addEdge(testDAGList.get(4));
		testDAGList.get(2).addEdge(testDAGList.get(5));
		testDAGList.get(2).addEdge(testDAGList.get(6));
		
		assertEquals("LCA of 4 and 5 is 2:", testDAGList.get(1), testDAG.LCA(testDAGList.get(3), testDAGList.get(4)));
		assertEquals("LCA of 2 and 3 is 1:", testDAGList.get(0), testDAG.LCA(testDAGList.get(1), testDAGList.get(2)));
	}
	
	@Test
	public void testTopological(){
		
		/**
		 * 1---2---3---4---5
		 * 
		 * index:	0 1 2 3 4
		 * number:	1 2 3 4 5
		 */
		
		LCA<Integer> testDAG = new LCA<>();
		ArrayList<Node_DAG<Integer>> testDAGList = new ArrayList<>();
		
		for(int i=0; i<5; i++){
			
			testDAGList.add(new Node_DAG<Integer>(i));
		}
		
		testDAG.root = testDAGList.get(0); //root = 1
		
		testDAGList.get(0).addEdge(testDAGList.get(1));
		testDAGList.get(1).addEdge(testDAGList.get(2));
		testDAGList.get(2).addEdge(testDAGList.get(3));
		testDAGList.get(3).addEdge(testDAGList.get(4));
		
		assertEquals("LCA of 1 and 2 is null:", null, testDAG.LCA(testDAGList.get(0), testDAGList.get(1)));
		assertEquals("LCA of 2 and 3 is 3:", testDAGList.get(2), testDAG.LCA(testDAGList.get(1), testDAGList.get(2)));
		assertEquals("LCA of 2 and 5 is 1:", testDAGList.get(0), testDAG.LCA(testDAGList.get(1), testDAGList.get(4)));
		assertEquals("LCA of 4 and 5 is 3:", testDAGList.get(2), testDAG.LCA(testDAGList.get(3), testDAGList.get(4)));
	}
}