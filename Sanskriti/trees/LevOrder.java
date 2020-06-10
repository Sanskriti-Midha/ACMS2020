package trees;

public class LevOrder {

	public static void levelOrder(Node root) {
		Node temp = root;
		Node arr[] = new Node[20];
		arr[0] = root;
		int i = 1;
		int j = 1;
		while (temp != null) {
			if (temp.left != null) {
				arr[i] = temp.left;
				i = i + 1;
			}
			if (temp.right != null) {
				arr[i] = temp.right;
				i = i + 1;
			}
			temp = arr[j];
			j = j + 1;
		}
		for (int k = 0; k < j-1; k++) {
			System.out.print(arr[k].data + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Node n1 = new Node(2, null, null);
		Node n3 = new Node(4, null, null);
		Node n4 = new Node(5,null, null);
		Node n2 = new Node(3, n3, n4);
		Node root = new Node(1, n1, n2);
		levelOrder(root);

	}

}
