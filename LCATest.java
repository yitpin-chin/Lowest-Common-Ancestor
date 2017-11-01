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
		
		testDAG.root = testDAGList.get(0); //add root = 1
		
		assertNotNull("Testing DAG not null after adding root:", testDAG);
	}
	
	@Test
	public void testEmptyTree(){
		
		LCA<Integer> testDAG = new LCA<>();
		ArrayList<Node_DAG<Integer>> testDAGList = new ArrayList<>();
		
		for(int i=0; i<7; i++){
			
			testDAGList.add(new Node_DAG<Integer>(i));
		}
		
		assertEquals("Trying to find LCA of empty tree. Should give null", null, testDAG.LCA(testDAGList.get(5), testDAGList.get(5)));
	}
	
}