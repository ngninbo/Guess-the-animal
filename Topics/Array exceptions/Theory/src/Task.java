// You can experiment here, it won’t be checked

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<List<Integer>> lists = new ArrayList<>();
    String line = scanner.nextLine();

    while (!line.isBlank()) {
      lists.add(Arrays.stream(line.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
      line = scanner.nextLine();
    }

    lists.forEach(list -> System.out.println(getHeap(list)));
  }

  public static String getHeap(List<Integer> list) {

    if (checkMax(list)) {
      return "max-heap";
    } else if (checkMin(list)) {
      return "min-heap";
    } else {
      return "not-heap";
    }
  }

  private static boolean checkMin(List<Integer> list) {
    int count = 0;

    for (int i = 1; i <= list.size(); i++) {
      int indexLeft = i * 2;
      int indexRight = i * 2 + 1;

      if (indexLeft < list.size() && list.get(indexLeft - 1) < list.get(i - 1)
              || indexRight < list.size() && list.get(indexRight - 1) < list.get(i - 1)) {
        count++;
      }
    }

    return count == 0;
  }

  private static boolean checkMax(List<Integer> list) {
    int count = 0;

    for (int i = 1; i <= list.size(); i++) {
      int indexLeft = i * 2;
      int indexRight = i * 2 + 1;

      if (indexLeft < list.size() && list.get(indexLeft - 1) > list.get(i - 1)
              || indexRight < list.size() && list.get(indexRight - 1) > list.get(i - 1)) {
        count++;
      }
    }

    return count == 0;
  }
}
