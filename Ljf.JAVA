import java.util.Scanner;
class B{
int[] wt=new int[10];
int[] tat=new int[10];
int[] bt=new int[10];
int[] p=new int[10];
int avg_wait, avg_turn,n;
int i;
void input()
{
 int x,j,k,temp;
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter number of process in the system:");
 n=sc.nextInt();
 for(i=0;i<n;i++)
{
 System.out.print("Enter the burst time for process "+(i+1)+":");
 bt[i]=sc.nextInt();
 p[i]=i+1;
}
for(x=0;x<n;x++)
{
 for(j=x+1;j<n;j++)
 {
  if(bt[x]<bt[j])
  {
    temp=bt[x];
    bt[x]=bt[j];
    bt[j]=temp;
    temp=p[x];
    p[x]=p[j];
    p[j]=temp;
  }
 }
}

}
void calc_avg_time()
{
  int sum1=0,sum2=0;
  for(i=0;i<n;i++)
 {
  sum1=sum1+wt[i];
  sum2=sum2+tat[i];
 }
 avg_wait=sum1/n;
 avg_turn=sum2/n;
}

void calc_waiting_time()
{
 wt[0]=0;
 for(i=1;i<n;i++)
 {
  wt[i]=bt[i-1]+wt[i-1];
 }
}

void calc_turn_time()
{
  for(i=0;i<n;i++)
 {
   tat[i]=wt[i]+bt[i];
}
}
void display()
{
System.out.println("process\tburst time\twaiting time\tturn around time");
  for(i=0;i<n;i++)
 {
  System.out.println( p[i]+"\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
 }
System.out.println(" Average waiting time is : "+avg_wait);
System.out.println(" Average turn around time is : "+avg_turn);
}
}

class Ljf{
public static void main(String args[])
{
B obj=new B();
obj.input();
obj.calc_waiting_time();
obj.calc_turn_time();
obj.calc_avg_time();
obj.display();
} 
}
