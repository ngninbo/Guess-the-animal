import java.util.Arrays;

class ThreadUtil {
    static void printNameOfTerminatedThread(Thread[] threads) {
        Arrays.stream(threads)
                .filter(thread -> Thread.State.TERMINATED.equals(thread.getState()))
                .findFirst().ifPresent(thread -> System.out.println(thread.getName()));
    }
}