
class ThreadUtil {
    static Thread createThreadInNewState() {
        return new Thread(() -> System.out.println("Simple thread"));
    }
}

class Main {
    public static void main(String[] args) {
        Thread thread = ThreadUtil.createThreadInNewState();
        System.out.println(thread.getState());
    }
}