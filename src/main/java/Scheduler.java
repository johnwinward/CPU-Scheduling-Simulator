import java.util.LinkedList;
import java.util.PriorityQueue;

public interface Scheduler {
    public abstract void addProcess(PCB process);
    public abstract void incrementClock();
    public abstract void run();
    public abstract void reset();
    public abstract void finish();
}
