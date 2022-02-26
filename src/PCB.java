//Process Control Block

public class PCB {

    private String name;
    private int processID;
    private int burstTime;
    private int arrivalTime;
    private int priority;

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
}
