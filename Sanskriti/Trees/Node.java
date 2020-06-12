package Trees;

public class Node {
	Node left;
	Node right;
	int data;
	public Node() {
		
	}
	public Node(int d, Node l, Node r) {
		left = l;
		right = r;
		data = d;
	}

}
