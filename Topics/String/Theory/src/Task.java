// You can experiment here, it won’t be checked

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
  public static void main(String[] args) {
    final String regex = "It (can|has|is)";
    final String string = "It can climb trees.\n"
            + "It has a horn\n"
            + "It is a shy animal";

    final Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
    final Matcher matcher = pattern.matcher(string);

    while (matcher.find()) {
      System.out.println("Full match: " + matcher.group(0));

      for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
      }
    }
  }
}
