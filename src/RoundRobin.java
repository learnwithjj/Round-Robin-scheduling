public class RoundRobin
{
	static void rr(int n,int at[],int bt[],int quantum)
	{
		int rm_bt[]=new int[n];					//keep track of remaining burst time
		for(int i=0;i<n;i++)
		{
			rm_bt[i]=bt[i];
		}
		int ct[]=new int[n];						//completion time
		int t=0;									//keep track of current time
		while(true)
		{
			boolean done=true;						
			for(int i=0;i<n;i++)
			{
				if(rm_bt[i]>0)						
				{
					done=false;							//all the processors have burst time left
					if(rm_bt[i]>quantum && at[i]<=t)	//when the processor is ready for execution(arrival time)
					{
						t+=quantum;						//executes for given time quantum
						rm_bt[i]-=quantum;				//cut down the burst time 
					}
					else
					{
						t+=rm_bt[i];
						rm_bt[i]=0;						//when the total process has been completed
					}
					if(rm_bt[i]==0)
					{									//when the individual processor has completed its process 
						ct[i]=t;
					}
				}
				
			}
				if(done==true)
					break;
		}
		int tat[]=new int[n];						//turn around time 
		for(int i=0;i<n;i++)
		{
			tat[i]=ct[i]-at[i];						//turn around time=completion time -arrival time
		}
		int waiting_time[]=new int[n];				//waiting time
		for(int i=0;i<n;i++)
		{
			waiting_time[i]=tat[i]-bt[i];			//waiting time==turn around time -burst time
		}
		System.out.println("Process  arrival_time  burst_time  turn_around_time  waiting_time ");
		int total_tat=0,total_waiting=0;
		for(int i=0;i<n;i++)
		{
			total_tat+=tat[i];						//total turn around time 
			total_waiting+=waiting_time[i];				//total waiting time
			System.out.printf("P%d",i+1);
			System.out.printf("  	 %d",at[i]);
			System.out.printf("    	  	 %d",bt[i]);
			System.out.printf("    	  	 %d",tat[i]);
			System.out.printf("    		%d\n",waiting_time[i]);
		}
		
		System.out.println("Average turn around time = "+(total_tat)/n);	//average turn around time
		System.out.println("Average waiting time = "+(total_waiting)/n);	//avergae waiting time
		
	}
	public static void main(String[] args)
	{
		int n=4;								//number of processors
		int quantum=3;							//time quantum or time slice
		int bt[]= {10,4,5,3};						//burst time
		int at[]= {0,1,2,3};						//arrival time
		rr(n,at,bt,quantum);
	}
}