import java.util.*;

public class FCFS
{
	public static void main(String args[])
	{ 	
	Scanner sc=new Scanner(System.in);
	System.out.print("\n Enter the no. of process: ");
	int i;
	int n=sc.nextInt();             //No. of process
	int bt[]=new int[n];		//Burst time for each process
	int tat[]=new int[n];		//turn aound time 
	int wt[]=new int[n];		//waiting time
	int p[]=new int[n];
	for(i=0;i<n;i++)
		{
		System.out.print("\n Enter process " + (i+1) + " burst time: ");
		bt[i]=sc.nextInt();
		}
	wt[0]=0;
	for(i=1;i<n;i++)
		{
		wt[i]=bt[i-1] + wt[i-1];
		}
 
	for(i=0;i<n;i++)
		{
		tat[i]=wt[i] + bt[i];
		}
	int sum=0,sum1=0,avg,avg1;	
	for(i=0;i<n;i++)
		{
		sum=sum + wt[i];
		sum1=sum1 + tat[i];
		}
	avg=sum/n;
	avg1=sum1/n;
	System.out.println("\n\tProcess\t\t" + "Duration\t" + "Waiting time\t");
	for(i=0;i<n;i++)
	{
	System.out.println("\t");
	System.out.println("\t" + i + "\t\t" +  bt[i] + "\t\t" + wt[i]);
	}
	System.out.println("\n Average of all waiting time: " + avg);
	System.out.println("\n Average of all turn around time: " + avg1);
	}
}