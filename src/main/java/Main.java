import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int n; //input value
        Scanner input = new Scanner(System.in);

        //Algorithms
        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();

        System.out.print("Enter the number of trials for each scheduling algorithm: ");
        n = input.nextInt();
        System.out.println("Trials being tested...  Will be written to Excel when finished.\n" +
                "Each trial will be separated by an empty row in the spreadsheet.");

        //Test processes from midterm exam
/*        PCB pA = new PCB("Process A", 1, 15, 0);
        PCB pB = new PCB("Process B", 2, 2, 2);
        PCB pC = new PCB("Process C", 3, 14, 3);
        PCB pD = new PCB("Process D", 4, 10, 6);
        PCB pE = new PCB("Process E", 5, 2, 10);

        fcfs.addProcess(pA);
        fcfs.addProcess(pB);
        fcfs.addProcess(pC);
        fcfs.addProcess(pD);
        fcfs.addProcess(pE);

        sjf.addProcess(pA);
        sjf.addProcess(pB);
        sjf.addProcess(pC);
        sjf.addProcess(pD);
        sjf.addProcess(pE); */

        //generate random processes
        while(n > 0){
            for(int i = 0; i < 5; i++){
                PCB process = new PCB();
                fcfs.addProcess(process);
                sjf.addProcess(process);
            }

            fcfs.run();
            sjf.run();

            fcfs.reset();
            sjf.reset();

            n--;
        }
        fcfs.finish();
        sjf.finish();
        //todo: close files when adding new algorithms

    }
}