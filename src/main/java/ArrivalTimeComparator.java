import java.util.Comparator;

class ArrivalTimeComparator implements Comparator<PCB> {
    public int compare(PCB p1, PCB p2){
        return Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
    }
}
