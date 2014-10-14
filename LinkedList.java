import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinkedList {

	public static void main(String[] args) {
		Node list = createList(args[0]);
		displayList(list);
		list=reverse(list);
		displayList(list);
	}

	public static Node createList(String file) {
		Node list = null;
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				list = addToHead(list, Integer.parseInt(sCurrentLine));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Node addToHead(Node list, int data) {
		Node head = new Node(data, null);
		head.next = list;
		return head;
	}

	public static Node reverse(Node list){
		if(list==null){
			return null;
		}else if(list.next==null){
			return list;
		}else{
			Node next=list.next;
			Node rev=reverse(next);
			next.next=list;
			list.next=null;
			return rev;
		}
		
	}
	
	public static void displayList(Node cur) {
		while (cur != null) {
			System.out.print(cur.data + "->");
			cur = cur.next;
		}
		System.out.println("NULL");

	}

}

class Node {
	int data;
	Node next;

	public Node(int data, Node next) {

		this.data = data;
		this.next = next;
	}

}
