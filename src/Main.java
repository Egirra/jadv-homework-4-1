import java.util.Queue;

public class Main {

    private static final int OPERATORS = 3;

    public static void main(String[] args) {
        ATS ats = new ATS(60);
        new Thread(ats).start();

        Queue<Call> callQueue = ats.getCalls();
        for (int i = 0; i < OPERATORS; i++) {
            Operator operator = new Operator(callQueue);
            new Thread(operator, "Оператор_" + (i + 1)).start();
        }
    }
}