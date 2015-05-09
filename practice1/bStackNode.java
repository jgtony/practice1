package hw5;

public class bStackNode {
	private int element1;
	private int element2;
	private bStackNode next;
	public bStackNode()
	{
		next = null;
	}
	public bStackNode(int data1,int data2,bStackNode node)
	{
		element1 = data1;
		element2 = data2;
		next = node;
	}
	public int getElement1() {return element1;}
	public int getElement2() {return element2;}
	public bStackNode getnext() { return next;}
	
}
