//Process Control Block
import java.util.Random;

public class PCB {
    //Constants
    private static final int MAX_BURST_TIME = 10;
    private static final int MAX_SIM_TIME = 10;

    //Process Count (will increase with each instance created)
    private static int n = 0;

    //Random Number Generator
    private static Random r = new Random();

    private String name;
    private int processID;
    private int burstTime;
    private int arrivalTime;
    private int burstTimeReset;
    private int arrivalTimeReset;
    private int completionTime;
    private int responseTime;
    private int waitTime;
    private int turnAroundTime;
    private int priority;

    PCB(){
        name = "Process " + n;
        processID = n++;
        burstTime = r.nextInt(1, MAX_BURST_TIME);
        arrivalTime = r.nextInt(MAX_SIM_TIME);
        burstTimeReset = burstTime;
        arrivalTimeReset = arrivalTime;
        completionTime = -1;
        responseTime = -1;
        waitTime = -1;
        turnAroundTime = -1;
        priority = -1; //priority can be assigned by scheduling algorithm
    }

    //Manually Assigned Constructor
    PCB(String name, int processID, int burstTime, int arrivalTime){
        this.name = name;
        this.processID = processID;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        burstTimeReset = burstTime;
        arrivalTimeReset = arrivalTime;
        completionTime = -1;
        responseTime = -1;
        turnAroundTime = -1;
        priority = -1;
    }

    public void reset(){
        burstTime = burstTimeReset;
        arrivalTime = arrivalTimeReset;
        completionTime = -1;
        responseTime = -1;
        waitTime = -1;
        turnAroundTime = -1;
        priority = -1;
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

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
}
