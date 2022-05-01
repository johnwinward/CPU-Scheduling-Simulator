import java.util.LinkedList;
import java.util.PriorityQueue;

public class FCFS {
    private PriorityQueue<PCB> arrivalQueue;
    private LinkedList<PCB> readyQueue;
    private Files files;
    private int clock;

    public boolean isDone() {
        return done;
    }

    boolean done;

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

    public void print(){
        System.out.println("Ready Queue: " + readyQueue);
        System.out.println("Arrival Queue: " + arrivalQueue);
        System.out.println("Clock: " + clock + "\n\n");
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
            clock += arrivalQueue.peek().getArrivalTime();
            readyQueue.add(arrivalQueue.remove());
        }
        if(arrivalQueue.isEmpty() && readyQueue.isEmpty()){
            done = true;
        }
        //print();
    }

    public void run() {
        while (!done)
            incrementClock();
        files.close();
    }
}