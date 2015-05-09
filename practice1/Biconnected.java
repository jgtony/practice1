package hw5;

import java.util.Arrays;

public class Biconnected {
	public int num;
	private int []dfn;
	private int []low;
	private int [][]arr;
	public int [][]sort;
	private int []arrorder;
	private int ct1;
	public int arrnum;
	public bStack st;
	public Biconnected(Graph G) {
		dfn = new int[G.V()];
		low = new int[G.V()];
		arrorder = new int[G.V()];
		st = new bStack(G.V());
		arr = new int[G.V()][G.V()];
		sort = new int[G.V()][G.V()];
		num=1;
		ct1=0;
		for(int i=0;i<G.V();i++)
		{
			dfn[i]=-1;
			low[i]=-1;
			for(int j=0;j<G.V();j++)
			{
				arr[i][j]=-1;
				sort[i][j]=-1;
			}
		}
		BCC(G,3,-1);
	}
	
	public void BCC(Graph G,int u, int v) {
		dfn[u] = num++;
		low[u] = dfn[u];
		for(int w=0;w<G.V();w++)
		{
			if(G.map[u][w]==1)
			{
				if((w!=v)&&(dfn[w]<dfn[u]))
				{
					st.push(u,w);			
				}
					
				if(dfn[w]==-1)
				{
					BCC(G,w,u);
					low[u] = Math.min(low[u], low[w]);
					if(low[w]>=dfn[u])
					{
						while(true)
						{
							int []temp = st.pop();
							arr[ct1][temp[0]]=1;
							arr[ct1][temp[1]]=1;
							if(temp[0]==u&&temp[1]==w)
							{
								ct1++;
								break;
							}
						}
					}
				}
				else if(w!=v)
				{
					low[u] = Math.min(low[u], dfn[w]);
				}
			}
		}
		arrnum=ct1;
	}
	public void show()
	{
		System.out.println("");
		for(int i=0;i<10;i++)
		{
			System.out.println("dfn["+i+"]="+dfn[i]+" low["+i+"]="+low[i]);	
		}
		
	}
	public void sort(Graph G)
	{
		int []temp;
		int count = 0;
		
		for(int i=0;i<G.V();i++)
		{
			count=0;
			for(int j=0;j<G.V();j++)
			{
				if(arr[i][j]!=-1)
					count++;
			}
			arrorder[i]=count;
		}
		
		for(int i=0;i<G.V();i++)
		{
			count=0;
			for(int j=0;j<G.V();j++)
			{
				if(arr[i][j]!=-1)
				{
					sort[i][count] = j;
					if(count!=9)
						count++;
				}
			}
		}
		int tmp=0;
		for(int i=0;i<arrnum-1;i++)
		{
			for(int j=i+1;j<arrnum;j++)
			{
				if(arrorder[i]>arrorder[j])
				{
					temp=sort[j];
					sort[j]=sort[i];
					sort[i]=temp;
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
					if(sort[j][i]>sort[k][i])
					{
						temp=sort[k];
						sort[k]=sort[j];
						sort[j]=temp;
					}
					else if(sort[j][i]==sort[k][i])
					{
						newsame = samenum(G,sort[j][i],i,same);
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
			if(sort[j][pos]==val)
				count++;
		}
		
		return count;
	}
}

