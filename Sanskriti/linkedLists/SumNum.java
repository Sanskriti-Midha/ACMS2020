package linkedLists;
import java.util.*;

public class SumNum {
	public static void main(String args[]) {
		LinkedLists ll1 = new LinkedLists();
		LinkedLists ll2 = new LinkedLists();
		LinkedLists ans = new LinkedLists();
		
		Scanner sc = new Scanner(System.in);
		String x;
		int y;
		Node temp = new Node(0);
		System.out.println("Enter first number(digit by digit):");
		x = sc.nextLine();
		do {
			y = Integer.parseInt(x);
			Node n = new Node(y);
			ll1.appendNode(n);
			x = sc.nextLine();
		}while(!(x.equals("")));
		
		System.out.println("Enter second number(digit by digit):");
		x = sc.nextLine();
		do {
			y = Integer.parseInt(x);
			Node n = new Node(y);
			ll2.appendNode(n);
			x = sc.nextLine();
		}while(!(x.equals("")));
		
		int n = ll1.calcLen();
		int m = ll2.calcLen();
		int k = 0;
		Node temp1 = ll1.head;
		Node temp2 = ll2.head;
		while(temp1!=null && temp2!=null) {
			if (ll1.head.digit < 0 && temp1 != ll1.head){
				temp1.digit = - temp1.digit;
			}
			if (ll2.head.digit < 0 && temp2 != ll2.head){
				temp2.digit = - temp2.digit;
			}
			k = k+ (int) ((temp1.digit)*(Math.pow(10, n-1)) + (temp2.digit)*(Math.pow(10, m-1)));
			temp1 = temp1.next;
			temp2=temp2.next;
			n = n-1;
			m = m-1;
		}
		
		while(temp1 !=null) {
			if (ll1.head.digit < 0 && temp1 != ll1.head){
				temp1.digit = - temp1.digit;
			}
			k = k + (int) ((temp1.digit)*(Math.pow(10, n-1)));
			temp1 = temp1.next;
			n = n-1;
		}
		
		while(temp2 !=null) {
			if (ll2.head.digit < 0 && temp2 != ll2.head){
				temp2.digit = - temp2.digit;
			}
			k = k + (int) ((temp2.digit)*(Math.pow(10, m-1)));
			temp2 = temp2.next;
			m = m-1;
		}
		
		int flag = 0;
		if(k<0) {
			k = -k;
			flag = -1;
		}
		while(k>0) {
			int a = k%10;
			Node an = new Node(a);
			ans.appendNode(an);
			k = (int) k/10;
		}
		ans.reverseList();
		if (flag == -1) {
			ans.head.digit = - ans.head.digit;
		}
		
		System.out.println("Answer is:");
		ans.printList();
	}

}
