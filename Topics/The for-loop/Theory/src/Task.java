// You can experiment here, it won’t be checked

import java.util.Scanner;
import java.util.stream.IntStream;

public class Task {
  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter number of lines: ");
    int numberOfLines = scanner.nextInt();

    IntStream.range(0, numberOfLines)
            .mapToObj(i -> repeat(" ", numberOfLines - (i + 1))
                    .concat(repeat("*", 2 * i + 1))
                    .concat(repeat(" ", numberOfLines - (i + 1))))
            .forEach(System.out::println);
  }

  private static String repeat(String str, int numberOfTimes) {
    return str.repeat(numberOfTimes);
  }
}
