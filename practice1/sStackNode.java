package hw5;

public class sStackNode {
	private int element1;
	private sStackNode next;
	public sStackNode()
	{
		next = null;
	}
	public sStackNode(int data1,sStackNode node)
	{
		element1 = data1;
		next = node;
	}
	public int getElement1() {return element1;}
	public sStackNode getnext() { return next;}
}
