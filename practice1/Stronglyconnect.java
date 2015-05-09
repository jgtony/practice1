package hw5;
import java.util.Arrays;

public class Stronglyconnect {
	public int num;
	private int []dfn;
	private int []low;
	public int [][]arr;
	private int []arrorder;
	private int ct1,ct2;
	public int arrnum;
	public sStack st;
	public Stronglyconnect(Graph G) {
		dfn = new int[G.V()];
		low = new int[G.V()];
		arrorder = new int[G.V()];
		arr = new int[G.V()][G.V()]; 
		st = new sStack(G.V());
		num=1;
		ct1=0;ct2=1;
		for(int i=0;i<G.V();i++)
		{
			dfn[i]=-1;
			low[i]=-1;
			for(int j=0;j<G.V();j++)
				arr[i][j]=-1;
		}
		for(int i=0;i<G.V();i++)
		{
			if(dfn[i]==-1)
				SCC(G,i);
		}
	}
	
	public void SCC(Graph G,int u) {
		dfn[u] = num++;
		low[u] = dfn[u];
		st.push(u);
		for(int w=0;w<G.V();w++)
		{
			if(G.map[u][w]==1)
			{	
				if(dfn[w]==-1)
				{
					SCC(G,w);
					low[u] = Math.min(low[u], low[w]);
				}
				else if(dfn[w]<dfn[u]&&st.find(w))
				{
					low[u] = Math.min(low[u], dfn[w]);
				}
			}
		}
		if(low[u]==dfn[u])
		{
			while(true)
			{
				int temp = st.pop();
				arr[ct1][ct2++]=temp;
				if(temp==u)
				{
					arrorder[ct1]=ct2-1;
					ct1++;
					ct2=1;
					break;
				}
			}
			arrnum = ct1;
		}
	}
	public void Show()
	{
		System.out.println("");
		for(int i=0;i<16;i++)
		{
			System.out.println("dfn["+i+"]="+dfn[i]+" low["+i+"]="+low[i]);	
		}		
	}
	public void sort(Graph G)
	{
		int []temp;
		
		for(int i=0;i<arrnum;i++)
		{
			Arrays.sort(arr[i]);
		}
		
		int tmp;
		for(int i=0;i<arrnum;i++)
		{
			for(int j=i+1;j<arrnum;j++)
			{
				if(arrorder[i]>arrorder[j])
				{
					temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
					tmp=arrorder[j];
					arrorder[j]=arrorder[i];
					arrorder[i]=tmp;
				}
			}
		}
		
		int []count2 = new int[G.V()];
		for(int i=0;i<G.V();i++) count2[i]=-1;
		for(int i=0;i<arrnum;i++)
		{
			for(int j=1;j<=G.V();j++)
			{
				if(arrorder[i]==j)
				{
					count2[j]++;
				}
			}
		}
		
		/*if(count2[1]+1>1)
		{
			System.out.println("sibal");
			for(int i=0;i<count2[1]+1;i++)
			{
				for(int j=i+1;j<count2[1]+1;j++)
				{
					if(arr[i][0]>arr[j][0])
					{
						System.out.println("sibal2");
						temp=arr[j];
						arr[j]=arr[i];
						arr[i]=temp;
					}
				}
			}
		}*/
		
		
		
		for(int i=2;i<G.V();i++)
		{
			if(count2[i]!=-1)
				sorting(G,count2[i]+1,0);
		}
	}
	public void sorting(Graph G,int same,int val)
	{
		int []temp;
		int newsame;
		for(int i=val;i<same;i++)
		{
			for(int j=0;j<same;j++)
			{
				for(int k=j+1;k<same;k++)
				{
					if(arr[j][i]>arr[k][i])
					{
						temp=arr[k];
						arr[k]=arr[j];
						arr[j]=temp;
					}
					else if(arr[j][i]==arr[k][i])
					{
						newsame = samenum(G,arr[j][i],i,same);
						sorting(G,newsame,val+1);
					}
				}
			}
		}
	}
	public int samenum(Graph G,int val,int pos,int same)
	{
		int count=0;
	
		for(int j=0;j<same;j++)
		{
			if(arr[j][pos]==val)
				count++;
		}
		
		return count;
	}
}
