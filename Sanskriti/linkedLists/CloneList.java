package linkedLists;

import java.util.*;

public class CloneList {
	public static void main(String args[]) {
		LinkedLists inp = new LinkedLists();
		LinkedLists clone = new LinkedLists();
		
		clone = cloneList(inp);
		clone.printList();
	}
	
	public static LinkedLists cloneList(LinkedLists inp) {
		LinkedLists clone = new LinkedLists();
		Node temp = inp.head;
		Node temp2;
		while(temp!=null) {
			clone.appendNode(temp);
			temp = temp.next;
		}
		temp = inp.head;
		temp2 = clone.head;
		while(temp!=null) {
			temp2.randptr = temp.randptr;
			temp2 = temp2.next;
			temp = temp.next;
		}
		
		return clone;
		
	}

}
