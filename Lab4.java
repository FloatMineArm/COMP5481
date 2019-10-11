package Lab;

public class Lab4 {

	public static void main(String[] args) {
		
		//tree structure
		BSTree tree = new BSTree();
		//input
		int[] data = {4,2,6,3,5,7,1};
		
		for(int elem: data) {
			tree.insert(elem);
		}
		
		tree.preTraversal();
		System.out.println();
		tree.inOrderTraversal();
		
		

	}
	
	

}
