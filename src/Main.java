public class Main {
    public static void main(String[] args){
        PCB[] processes = new PCB[50];
        for(int i = 0; i < 50; i++) {
            processes[i] = new PCB();
            System.out.println(processes[i].toString());
        }
    }
}
