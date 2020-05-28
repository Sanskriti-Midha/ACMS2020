package linkedLists;

public class LinkedLists {
	Node head;

	public void appendNode(Node n) {
		Node temp = head;
		if (temp == null) {
			head = n;
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
		}
	}
	
	public int calcLen() {
		int len = 0;
		Node temp = head;
		while(temp != null) {
			temp = temp.next;
			len = len+1;
		}
		return len;
	}

	public void reverseList() {
		Node curnode = head;
		Node temp = head , prevnode = null;
		while(curnode!=null) {
			temp = curnode.next;
			curnode.next = prevnode;
			prevnode = curnode;
			curnode = temp;
		}
		head = prevnode;
	}
	public void printList() {
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.digit + " -> ");
			temp = temp.next;
		}
		System.out.print(temp.digit + "\n");
	}

}
