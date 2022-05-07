/*
    CPU Scheduling Simulator: A Discrete Event Simulator for analyzing
    various CPU scheduling algorithms. Data is written to an Excel spreadsheet.

    Semester project for CPSC 340: Operating Systems Concepts and Design
    Author: John Winward
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int n; //input value
        Scanner input = new Scanner(System.in);

        //Algorithms
        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
        RR rr = new RR();
        SRTN srtn = new SRTN();

        System.out.print("Enter the number of trials for each scheduling algorithm: ");
        n = input.nextInt();
        System.out.println("Trials being tested...  Will be written to Excel when finished.\n" +
                "Each trial will be separated by an empty row in the spreadsheet.");

        //Test processes from midterm exam
/*        PCB pA = new PCB("Process A", 1, 15, 0);
        PCB pB = new PCB("Process B", 2, 2, 2);
        PCB pC = new PCB("Process C", 3, 14, 3);
        PCB pD = new PCB("Process D", 4, 10, 6);
        PCB pE = new PCB("Process E", 5, 2, 10); */

/*        PCB pA = new PCB("Process A", 1, 2, 2);
        PCB pB = new PCB("Process B", 2, 2, 5);
        PCB pC = new PCB("Process C", 3, 5, 8);
        PCB pD = new PCB("Process D", 4, 8, 3);
        PCB pE = new PCB("Process E", 5, 8, 7);

        fcfs.addProcess(pA);
        fcfs.addProcess(pB);
        fcfs.addProcess(pC);
        fcfs.addProcess(pD);
        fcfs.addProcess(pE);

        sjf.addProcess(pA);
        sjf.addProcess(pB);
        sjf.addProcess(pC);
        sjf.addProcess(pD);
        sjf.addProcess(pE);

        rr.addProcess(pA);
        rr.addProcess(pB);
        rr.addProcess(pC);
        rr.addProcess(pD);
        rr.addProcess(pE);

        srtn.addProcess(pA);
        srtn.addProcess(pB);
        srtn.addProcess(pC);
        srtn.addProcess(pD);
        srtn.addProcess(pE);

        fcfs.run();
        fcfs.finish();

        sjf.run();
        sjf.finish();

        rr.run();
        rr.finish();

        srtn.run();
        srtn.finish(); */

        //generate random processes
        while(n > 0){
            for(int i = 0; i < 5; i++){
                PCB process = new PCB();
                fcfs.addProcess(process);
                sjf.addProcess(process);
                rr.addProcess(process);
                srtn.addProcess(process);
            }

            fcfs.run();
            sjf.run();
            rr.run();
            srtn.run();

            fcfs.reset();
            sjf.reset();
            rr.reset();
            srtn.reset();

            n--;
        }
        fcfs.finish();
        sjf.finish();
        rr.finish();
        srtn.finish();
    }
}