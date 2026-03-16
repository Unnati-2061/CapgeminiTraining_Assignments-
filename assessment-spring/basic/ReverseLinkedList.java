package com.foundation;

public class ReverseLinkedList {
	static class Node {
		public int data;
		public Node next;
		
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	static class MyLinkedList {
		public Node head;
		
		MyLinkedList() { head = null; }
		
		MyLinkedList(int val) {
			head = new Node(val);
		}
		
		public void add(int val) {
			if (head == null)
				head = new Node(val);
			else {
				Node curr = head;
				
				while(curr.next != null)
					curr = curr.next;
				
				curr.next = new Node(val);
			}
		}
		
		public void reverse() {
			Node curr = head;
			Node prev = null;
			Node next = curr.next;
			
			while(curr != null) {
				curr.next = prev;
				prev = curr;
				curr = next;
				if (next != null)
					next = next.next;
			}
			
			head = prev;
		}
		
		public void print() {
			Node curr = head;
			
			while(curr != null) {
				System.out.print(curr.data + " --> ");
				curr = curr.next;
			}

			System.out.println("null");
		}
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		for(int i=1; i<=5; i++) list.add(i*10);
		
		System.out.println("Original Linked List:");
		list.print();
		
		System.out.println("\nRevered Linked List:");
		list.reverse();
		list.print();
	}
}
