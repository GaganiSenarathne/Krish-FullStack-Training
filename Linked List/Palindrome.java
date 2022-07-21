import java.util.Stack;

public class Palindrome {

	    public static void main(String args[])
	    {
	        Node first = new Node(10);
	        Node second = new Node(20);
	        Node third = new Node(30);
	        Node fourth = new Node(40);
	        Node fifth = new Node(30);
	        Node sixsth = new Node(20);
	        Node seventh = new Node(10);
	        
	        first.nodePtr = second;
	        second.nodePtr = third;
	        third.nodePtr = fourth;
	        fourth.nodePtr = fifth;
	        fifth.nodePtr = sixsth;
	        sixsth.nodePtr = seventh;
	        
	        boolean condition = isPalindrome(first);
	        
	        if(condition) {
	        	System.out.println("It is a palidrome");
	        }else {
	        	System.out.println("It is not a palidrome");
	        }
	    }
	    static boolean isPalindrome(Node head)
	    {
	  
	        Node slow = head;
	        boolean ispalin = true;
	        Stack<Integer> stack = new Stack<Integer>();
	  
	        while (slow != null) {
	            stack.push(slow.data);
	            slow = slow.nodePtr;
	        }
	  
	        while (head != null) {
	  
	            int i = stack.pop();
	            if (head.data == i) {
	                ispalin = true;
	            }
	            else {
	                ispalin = false;
	                break;
	            }
	            head = head.nodePtr;
	        }
	        return ispalin;
	    }
	}
	  
	class Node {
	    int data;
	    Node nodePtr;
	    Node(int d)
	    {
	        nodePtr = null;
	        data = d;
	    }
	}