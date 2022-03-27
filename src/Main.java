public class Main {
    public static void main(String[] args){
        PCB pA = new PCB("Process A", 1, 15, 0);
        PCB pB = new PCB("Process B", 2, 2, 2);
        PCB pC = new PCB("Process C", 3, 14, 3);
        PCB pD = new PCB("Process D", 4, 10, 6);
        PCB pE = new PCB("Process E", 5, 2, 10);

        FCFS fcfs = new FCFS();
        fcfs.addProcess(pA);
        fcfs.addProcess(pB);
        fcfs.addProcess(pC);
        fcfs.addProcess(pD);
        fcfs.addProcess(pE);

        while(!fcfs.isDone()){
            fcfs.incrementClock();
        }

        //Instantiate Scheduling Objects
    }
}
