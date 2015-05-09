package hw5;

import java.io.*;
import java.util.Scanner;

public class main {

	private static void err(int code) {
		System.exit(code);
	}

	public static void main(String[] args) {
		int numOfTestCases = 0;
		int numOfNodes = 0; 
		String mode = null; 
		Scanner sc = null;
		java.io.PrintStream ps = null;
		int node1 = 0; 
		int node2 = 0; 
		int casenum = 1;

		try {
			sc = new Scanner(new File("C:\\hw5\\input.txt"));
			ps = new java.io.PrintStream("C:\\hw5\\2014147518.txt");
		} catch (Exception exception) {
			err(1);
		}
		if (sc.hasNextInt())
			numOfTestCases = sc.nextInt();
		
		while(numOfTestCases > 0) {
			numOfTestCases--;
			ps.println(casenum++);			
			
			if (sc.hasNext())
				mode = sc.next(); 
			else
				err(2);
			if (sc.hasNextInt())
				numOfNodes = sc.nextInt(); 
			else
				err(3);
			
			Graph graph = new Graph(numOfNodes);
			if(numOfNodes>1000) err(1);
			
			while (sc.hasNextInt()) {
				node1 = sc.nextInt();
				if (sc.hasNextInt())
					node2 = sc.nextInt();
				else
					err(3);
				
				if(mode.equals("bcc") || mode.equals("BCC"))
					graph.insertbcc(node2, node1); 
				else if(mode.equals("scc") || mode.equals("SCC"))
					graph.insertscc(node2, node1); 
				
			}
			if(mode.equals("bcc") || mode.equals("BCC"))
			{
				Biconnected bcc = new Biconnected(graph);	
				bcc.sort(graph);
				
				for(int i=0;i<bcc.arrnum;i++)
				{
					for(int j=0;j<graph.V();j++)
					{
						if(bcc.sort[i][j]!=-1)
						{
							ps.print(bcc.sort[i][j]+" ");
						}
					}
					ps.println("");
				}
			}
			else if(mode.equals("scc") || mode.equals("SCC"))
			{
				Stronglyconnect scc = new Stronglyconnect(graph);
				scc.sort(graph);
				
				for(int i=0;i<scc.arrnum;i++)
				{
					for(int j=0;j<graph.V();j++)
					{
						if(scc.arr[i][j]!=-1)
						{
							ps.print(scc.arr[i][j]+" ");
						}
					}
					ps.println("");
				}
			}
		
			
		}
		sc.close();
	}
}