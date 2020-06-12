package Trees;

public class SumEqN {
	public static int arr[] = new int[20];
	public static int i = 0;

	public static void inorderTraverse(Node root) {
		if (root == null) {
			return;
		}

		inorderTraverse(root.left);
		arr[i++] = root.data;
		//System.out.println(root.data);
		inorderTraverse(root.right);

	}
	
	public static int[] sumEqualsN(int sum) {
		int ans[] = new int[2];
		ans[0] = -1;
		ans[1] = -1;
		int k = 0, j = i-1;
		while(k!=j) {
			if(arr[k]+arr[j] == sum) {
				ans[0] = arr[k];
				ans[1] = arr[j];
				break;
			}
			else if(arr[k]+arr[j]<sum) {
				k = k+1;
			}
			else 
				j = j-1;
		}
		return ans;
	} 

	public static void main(String args[]) {
		Node n1 = new Node(1, null, null);
		Node n4 = new Node(5, null, null);
		Node n3 = new Node(4, null, n4);
		Node n2 = new Node(3, null, n3);
		Node root = new Node(2, n1, n2);
		inorderTraverse(root);
		int ans[] = sumEqualsN(9);
		if(ans[0] == -1 && ans[1] == -1)
			System.out.println("No to number equal given sum");
		else
			System.out.println(ans[0] +","+ ans[1]);
	}

}
