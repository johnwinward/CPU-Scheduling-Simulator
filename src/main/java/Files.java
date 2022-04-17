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
        row1[0] = "Process Name";
        row1[1] = "Process ID";
        row1[2] = "Burst Time";
        row1[3] = "Arrival Time";
        row1[4] = "Response Time";
        row1[5] = "Turn Around Time";
        row1[6] = "Completion Time";
        row1[7] = "Priority Value";

        out.writeNext(row1);
    }

    public void writePCB(PCB process){
        String[] row = new String[8];
        row[0] = process.getName();
        row[1] = "" + process.getProcessID();
        row[2] = "" + process.getBurstTime();
        row[3] = "" + process.getArrivalTime();
        row[4] = "" + process.getResponseTime();
        row[5] = "" + (process.getCompletionTime() - process.getArrivalTime());
        row[6] = "" + process.getCompletionTime();
        row[7] = "" + process.getPriority();

        out.writeNext(row);
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
