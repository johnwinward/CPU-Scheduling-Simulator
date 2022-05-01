import java.util.Comparator;

class BurstTimeComparator implements Comparator<PCB> {
    public int compare(PCB p1, PCB p2){
        return Integer.compare(p1.getBurstTime(), p2.getBurstTime());
    }
}
