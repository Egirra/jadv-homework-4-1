import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ATS implements Runnable {
    private int callCount;
    private LinkedBlockingQueue<Call> calls;
    private final int WORK_ATS = 1000;

    public ATS(int callCount) {
        this.callCount = callCount;
        calls = new LinkedBlockingQueue<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < callCount; i++) {
            calls.offer(new Call());
            System.out.println("Звонок добавлен в очередь");
            try {
                Thread.sleep(WORK_ATS);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public LinkedBlockingQueue<Call> getCalls() {
        return calls;
    }
}