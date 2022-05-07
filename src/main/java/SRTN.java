import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SRTN implements Scheduler{
    private PriorityQueue<PCB> arrivalQueue;
    private PriorityQueue<PCB> readyQueue;
    private HashMap<Integer, Integer> burstTimes;
    private Files files;
    private int clock;
    private boolean done;

    public SRTN(){
        ArrivalTimeComparator aComparator = new ArrivalTimeComparator();
        BurstTimeComparator bComparator = new BurstTimeComparator();
        arrivalQueue = new PriorityQueue<PCB>(aComparator);
        readyQueue = new PriorityQueue<PCB>(bComparator);
        burstTimes = new HashMap<Integer, Integer>();
        files = new Files("SRTN");
        clock = -1;
        done = false;
    }

    public void reset(){
        ArrivalTimeComparator aComparator = new ArrivalTimeComparator();
        BurstTimeComparator bComparator = new BurstTimeComparator();
        arrivalQueue = new PriorityQueue<PCB>(aComparator);
        readyQueue = new PriorityQueue<PCB>(bComparator);
        clock = -1;
        done = false;
    }

    public void finish(){
        files.close();
    }

    public void addWaitTime(int t){
        for(PCB process : readyQueue){
            process.setWaitTime(process.getWaitTime() + t);
        }
    }

    public void run() {
        for(PCB process : arrivalQueue)
            process.reset();
        while (!done)
            incrementClock();
        files.writeClock(clock);
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
        while(!arrivalQueue.isEmpty() && arrivalQueue.peek().getArrivalTime() == clock){
            arrivalQueue.peek().setWaitTime(0);
            readyQueue.add(arrivalQueue.remove());
        }
        if(!arrivalQueue.isEmpty() && !readyQueue.isEmpty()){
            if(readyQueue.peek().getBurstTime() == burstTimes.get(readyQueue.peek().getProcessID()))
                readyQueue.peek().setResponseTime(clock - readyQueue.peek().getArrivalTime());
            if(readyQueue.peek().getBurstTime() + clock <= arrivalQueue.peek().getArrivalTime()){
                clock += readyQueue.peek().getBurstTime();
                readyQueue.peek().setCompletionTime(clock);
                int t = readyQueue.peek().getBurstTime();
                readyQueue.peek().setBurstTime(burstTimes.get(readyQueue.peek().getProcessID()));
                files.writePCB(readyQueue.remove());
                addWaitTime(t);
            }
            else{
                readyQueue.peek().setBurstTime(readyQueue.peek().getBurstTime() - (arrivalQueue.peek().getArrivalTime() - clock));
                int t = arrivalQueue.peek().getArrivalTime() - clock;
                clock = arrivalQueue.peek().getArrivalTime();
                PCB p = readyQueue.remove();
                addWaitTime(t);
                readyQueue.add(p);
                arrivalQueue.peek().setWaitTime(0);
                readyQueue.add(arrivalQueue.remove());
            }
        }
        else if(!readyQueue.isEmpty()){
            if(readyQueue.peek().getBurstTime() == burstTimes.get(readyQueue.peek().getProcessID()))
                readyQueue.peek().setResponseTime(clock - readyQueue.peek().getArrivalTime());
            clock += readyQueue.peek().getBurstTime();
            int t = readyQueue.peek().getBurstTime();
            readyQueue.peek().setCompletionTime(clock);
            readyQueue.peek().setBurstTime(burstTimes.get(readyQueue.peek().getProcessID()));
            files.writePCB(readyQueue.remove());
            addWaitTime(t);
        }
        if(arrivalQueue.isEmpty() && readyQueue.isEmpty()){
            done = true;
        }
    }
}
