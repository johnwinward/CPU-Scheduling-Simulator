import java.util.PriorityQueue;

public class SJF {
    private PriorityQueue<PCB> arrivalQueue;
    private PriorityQueue<PCB> readyQueue;
    private Files files;
    private int clock;
    boolean done;

    public SJF() {
        ArrivalTimeComparator aComparator = new ArrivalTimeComparator();
        BurstTimeComparator bComparator = new BurstTimeComparator();
        arrivalQueue = new PriorityQueue<PCB>(aComparator);
        readyQueue = new PriorityQueue<PCB>(bComparator);
        files = new Files("SJF");
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
        if(clock == -1 && !arrivalQueue.isEmpty()){
            clock = 0;
            clock += arrivalQueue.peek().getBurstTime();
            arrivalQueue.peek().setCompletionTime(clock);
            arrivalQueue.peek().setResponseTime(0);
            arrivalQueue.peek().setWaitTime(0);
            files.writePCB(arrivalQueue.remove());
        }
        else{
            while(!arrivalQueue.isEmpty() && clock >= arrivalQueue.peek().getArrivalTime()){
                readyQueue.add(arrivalQueue.remove());
            }
            if(!arrivalQueue.isEmpty() && readyQueue.isEmpty()){
                clock = arrivalQueue.peek().getArrivalTime();
            }
            if(!readyQueue.isEmpty()){
                readyQueue.peek().setResponseTime(clock - readyQueue.peek().getArrivalTime());
                readyQueue.peek().setWaitTime(clock - readyQueue.peek().getArrivalTime());
                clock += readyQueue.peek().getBurstTime();
                readyQueue.peek().setCompletionTime(clock);
                files.writePCB(readyQueue.remove());
            }
            if(readyQueue.isEmpty() && arrivalQueue.isEmpty())
                done = true;
        }
    }

    public void run(){
        while (!done)
            incrementClock();
        files.close();
    }
}
