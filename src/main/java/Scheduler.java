import java.util.LinkedList;
import java.util.PriorityQueue;

public interface Scheduler {
    public abstract void addProcess(PCB process); //Add process to arrival queue in scheduler
    public abstract void incrementClock(); //Executes the scheduler according to the implemented algorithm
    public abstract void run(); //runs incrementClock() until no processes remain
    public abstract void reset(); //resets scheduler to initial state for new testing trial
    public abstract void finish(); //closes associated files
}
