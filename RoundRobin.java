import java.util.Scanner;
class C{
int[] wt=new int[10];
int[] tat=new int[10];
int[] bt=new int[10];
int[] rm=new int[10];
int avg_wait, avg_turn,quant=5,t=0;
int i,n;
void input()
{
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter number of process in the system:");
 n=sc.nextInt();
 for(i=0;i<n;i++)
{
 System.out.print("Enter the burst time for process "+(i+1)+":");
 bt[i]=sc.nextInt();
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
 for(i=0;i<n;i++)
 {
  rm[i]=bt[i];
 }
 while(true)
{
  int f=1;
for(i=0;i<n;i++)
{
  if(rm[i]>0)
  {
     f=0;
     if(rm[i]>quant)
     {
       t=t+quant;
       rm[i]=rm[i]-quant;
     }
     else
     {
        t=t+rm[i];
        wt[i]=t-bt[i];
        rm[i]=0;
     }
  }
}
if(f==1)
 break;
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
  System.out.println(  (i+1)+"\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
 }
System.out.println(" Average waiting time is : "+avg_wait);
System.out.println(" Average turn around time is : "+avg_turn);
}
}
class Round{
public static void main(String args[])
{
C obj=new C();
obj.input();
obj.calc_waiting_time();
obj.calc_turn_time();
obj.calc_avg_time();
obj.display();
} 
}