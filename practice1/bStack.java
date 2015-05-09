package hw5;

public class bStack {
	public bStackNode top;
	public int size;
	public bStack(int num){
		size=0;
	}
	public boolean isEmpty()
	{
		if(top==null) return true;
		return false;
	}
	public void push(int data1,int data2)
	{
		bStackNode newnode = new bStackNode(data1,data2,top);
		top=newnode;
		size++;
	}
	public int[] pop()
	{
		int []data = new int[2];
		data[0] = top.getElement1();
		data[1] = top.getElement2();
		size--;
		top = top.getnext();	
		return data;
	}
}
