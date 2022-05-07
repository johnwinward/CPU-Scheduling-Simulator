//First Come, First Served CPU Scheduling Algorithm

import java.util.LinkedList;
import java.util.PriorityQueue;

public class FCFS implements Scheduler{
    private PriorityQueue<PCB> arrivalQueue;
    private LinkedList<PCB> readyQueue;
    private Files files;
    private int clock;
    private boolean done;

    public FCFS() {
        ArrivalTimeComparator comparator = new ArrivalTimeComparator();
        arrivalQueue = new PriorityQueue<PCB>(comparator);
        readyQueue = new LinkedList<PCB>();
        files = new Files("FCFS");
        clock = -1;
        done = false;
    }

   public void addProcess(PCB process){
        arrivalQueue.add(process);
    }

    public void incrementClock(){
        if (clock == -1){
            PCB p = arrivalQueue.remove();
            clock = p.getArrivalTime();
            readyQueue.add(p);
        }
        if(!readyQueue.isEmpty()){
            readyQueue.peek().setResponseTime(clock - readyQueue.peek().getArrivalTime());
            readyQueue.peek().setWaitTime(clock - readyQueue.peek().getArrivalTime());
            clock += readyQueue.peek().getBurstTime();
            readyQueue.peek().setCompletionTime(clock);
            files.writePCB(readyQueue.remove());
        }
        while(!arrivalQueue.isEmpty() && arrivalQueue.peek().getArrivalTime() <= clock)
            readyQueue.add(arrivalQueue.remove());
        if(readyQueue.isEmpty() && !arrivalQueue.isEmpty()){
            clock = arrivalQueue.peek().getArrivalTime();
            readyQueue.add(arrivalQueue.remove());
        }
        if(arrivalQueue.isEmpty() && readyQueue.isEmpty()){
            done = true;
        }
    }

    public void run() {
        for(PCB process : arrivalQueue)
            process.reset();
        while (!done)
            incrementClock();
        files.writeClock(clock);
    }

    public void reset(){
        ArrivalTimeComparator comparator = new ArrivalTimeComparator();
        arrivalQueue = new PriorityQueue<PCB>(comparator);
        readyQueue = new LinkedList<PCB>();
        clock = -1;
        done = false;
        files.newTrial();
    }

    public void finish(){
        files.close();
    }
}