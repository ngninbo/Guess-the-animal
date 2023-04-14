import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) {
        final int upper = 10;

        IntStream.iterate(upper - 1, i -> i >= 0, i -> i - 1)
                .forEach(i -> System.out.printf("%s ", i));
    }
}