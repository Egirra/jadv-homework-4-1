import java.util.Queue;

public class Operator implements Runnable{
    private final int WORK_OPERATOR = 3000;
    private Queue<Call> callQueue;

    public Operator(Queue<Call> queue) {
        callQueue = queue;
    }

    @Override
    public void run() {
        while (!callQueue.isEmpty()) {
            Call call = callQueue.poll();
            if (call == null) {
                continue;
            }
            System.out.println(Thread.currentThread().getName() + " обрабатывает звонок");
            try {
                Thread.sleep(WORK_OPERATOR);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}