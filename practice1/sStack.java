package hw5;

public class sStack {
	public sStackNode top;
	public int size;
	public sStack(int num){
		size=0;
	}
	public boolean isEmpty()
	{
		if(top==null) return true;
		return false;
	}
	public void push(int data1)
	{
		sStackNode newnode = new sStackNode(data1,top);
		top=newnode;
		size++;
	}
	public int pop()
	{
		int data = top.getElement1();
		size--;
		top = top.getnext();	
		return data;
	}
	public boolean find(int a)
	{
		sStackNode p = top.getnext();
		while(p!=null)
		{
			if(p.getElement1()==a)
			{
				return true;
			}
			p = p.getnext();
		}
		return false;
	}
}
