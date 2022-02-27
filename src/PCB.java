//Process Control Block

import java.util.Random;

public class PCB {
    //Constants
    private static final int MAX_BURST_TIME = 1000;
    private static final int MAX_SIM_TIME = 100000;

    //Process Count (will increase with each instance created)
    private static int n = 0;

    //Random Number Generator
    private static Random r = new Random();

    //Instance variables
    private String name;
    private int processID;
    private int burstTime;
    private int arrivalTime;
    private int priority;

    //Default Constructor
    PCB(){
        name = "Process " + n;
        processID = n++;
        burstTime = r.nextInt(0, MAX_BURST_TIME);
        arrivalTime = r.nextInt(MAX_SIM_TIME);
        priority = 0; //priority will be assigned by scheduling algorithm
    }

    //Manually Assigned Constructor
    PCB(String name, int processID, int burstTime, int arrivalTime){
        this.name = name;
        this.processID = processID;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        priority = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "PCB{" +
                "name='" + name + '\'' +
                ", processID=" + processID +
                ", burstTime=" + burstTime +
                ", arrivalTime=" + arrivalTime +
                ", priority=" + priority +
                '}';
    }
}
