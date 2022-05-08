//File Handler for Schedulers

import com.opencsv.CSVWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class Files {
    private CSVWriter out;
    private FileInputStream in;

    Files(String algorithmName){
        try {
            out = new CSVWriter(new FileWriter(algorithmName + "Out.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //todo: instantiate input file

        //Write title row
        String[] row1 = new String[8];
        row1[0] = "Name";
        row1[1] = "PID";
        row1[2] = "AT";
        row1[3] = "BT";
        row1[4] = "CT";
        row1[5] = "TAT";
        row1[6] = "WT";
        row1[7] = "RT";

        out.writeNext(row1);
    }

    public void writePCB(PCB process){
        String[] row = new String[8];
        row[0] = process.getName();
        row[1] = "" + process.getProcessID();
        row[2] = "" + process.getArrivalTime();
        row[3] = "" + process.getBurstTime();
        row[4] = "" + process.getCompletionTime();
        row[5] = "" + (process.getCompletionTime() - process.getArrivalTime());
        row[6] = "" + process.getWaitTime();
        row[7] = "" + process.getResponseTime();

        out.writeNext(row);
    }

    public void writeClock(int c){
        String[] row = new String[2];
        row[0] = "Clock: ";
        row[1] = "" + c;
        out.writeNext(row);
    }

    public void newTrial(){ //Trials are separated by an empty row in the spreadsheet
        out.writeNext(new String[1]);
    }

    public void close(){
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //todo: close input file
    }

}
