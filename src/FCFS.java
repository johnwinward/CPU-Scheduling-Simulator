import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FCFS {
    private PriorityQueue<PCB> arrivalQueue;
    private LinkedList<PCB> readyQueue;
    private int clock;

    public boolean isDone() {
        return done;
    }

    boolean done;
    private PCB currentProcess;

    public FCFS() {
        ArrivalTimeComparator comparator = new ArrivalTimeComparator();
        arrivalQueue = new PriorityQueue<PCB>(comparator);
        readyQueue = new LinkedList<PCB>();
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
        /*if(clock == -1){
            currentProcess = arrivalQueue.remove();
            clock = currentProcess.getArrivalTime();
        }

        System.out.println(clock);
        printRQ();
        while(!arrivalQueue.isEmpty() && arrivalQueue.peek().getArrivalTime() <= clock) {
            readyQueue.add(arrivalQueue.remove());
        }
        if(!arrivalQueue.isEmpty()){
            clock += currentProcess.getBurstTime();
            if(!readyQueue.isEmpty()){
                currentProcess = readyQueue.remove();
            }
            else{
                clock = arrivalQueue.peek().getArrivalTime();
            }
        }
        else
            done = true; */
    }
}
