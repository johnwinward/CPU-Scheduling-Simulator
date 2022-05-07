//Round Robin CPU Scheduling Algorithm

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class RR implements Scheduler{
    private PriorityQueue<PCB> arrivalQueue;
    private LinkedList<PCB> readyQueue;
    private HashMap<Integer, Integer> burstTimes;
    private Files files;
    private int clock;
    private int preempts;
    private int timeQ;
    boolean done;

    public RR() {
        ArrivalTimeComparator comparator = new ArrivalTimeComparator();
        arrivalQueue = new PriorityQueue<PCB>(comparator);
        readyQueue = new LinkedList<PCB>();
        burstTimes = new HashMap<Integer, Integer>();
        files = new Files("RR");
        clock = -1;
        preempts = 0;
        timeQ = 5;
        done = false;
    }

    public void addProcess(PCB process){
        arrivalQueue.add(process);
        burstTimes.put(process.getProcessID(), process.getBurstTime());
    }

    public void incrementClock(){
        if(clock == -1 && !arrivalQueue.isEmpty()){
            clock = arrivalQueue.peek().getArrivalTime();
            arrivalQueue.peek().setResponseTime(0);
        }
        while(!arrivalQueue.isEmpty() && arrivalQueue.peek().getArrivalTime() <= clock){
            arrivalQueue.peek().setWaitTime(clock - arrivalQueue.peek().getArrivalTime());
            readyQueue.add(arrivalQueue.remove());
        }
        if(!readyQueue.isEmpty()){
            if(readyQueue.peek().getResponseTime() == -1)
                readyQueue.peek().setResponseTime(clock - readyQueue.peek().getArrivalTime());
            if(readyQueue.peek().getBurstTime() <= timeQ){
                clock += readyQueue.peek().getBurstTime();
                int t = readyQueue.peek().getBurstTime();
                readyQueue.peek().setCompletionTime(clock);
                readyQueue.peek().setBurstTime(burstTimes.get(readyQueue.peek().getProcessID()));
                files.writePCB(readyQueue.remove());
                addWaitTime(t);
            }
            else{
                clock += timeQ;
                readyQueue.peek().setBurstTime(readyQueue.peek().getBurstTime() - timeQ);
                PCB p = readyQueue.remove();
                addWaitTime(timeQ);
                while(!arrivalQueue.isEmpty() && arrivalQueue.peek().getArrivalTime() <= clock){
                    arrivalQueue.peek().setWaitTime(clock - arrivalQueue.peek().getArrivalTime());
                    readyQueue.add(arrivalQueue.remove());
                }
                readyQueue.add(p);
            }
        }
        if(readyQueue.isEmpty() && arrivalQueue.isEmpty()){
            done = true;
        }
    }

    public void run() {
        for(PCB process : arrivalQueue)
            process.reset();
        while (!done)
            incrementClock();
    }

    public void reset(){
        ArrivalTimeComparator comparator = new ArrivalTimeComparator();
        arrivalQueue = new PriorityQueue<PCB>(comparator);
        readyQueue = new LinkedList<PCB>();
        clock = -1;
        preempts = 0;
        done = false;
        files.newTrial();
    }

    public void finish() {
        files.close();
    }

    public void setTimeQ(int q){
        timeQ = q;
    }

    public void addWaitTime(int t){
        for(PCB process : readyQueue){
            process.setWaitTime(process.getWaitTime() + t);
        }
    }
}
