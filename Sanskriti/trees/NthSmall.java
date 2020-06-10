package trees;

public class NthSmall {

	public static int ct = 0;

	public static void inorderTraverse(int N, Node root) {
		if (root == null) {
			return;
		}
		if (ct <= N) {
			inorderTraverse(N, root.left);
			ct = ct + 1;
			if (ct == N) {
				System.out.println(root.data);
			}
			inorderTraverse(N, root.right);
		}
	}

	public static void main(String args[]) {
		Node n1 = new Node(1, null, null);
		Node n4 = new Node(5, null, null);
		Node n3 = new Node(4, null, n4);
		Node n2 = new Node(3, null, n3);
		Node root = new Node(2, n1, n2);
		inorderTraverse(2, root);

	}

}
