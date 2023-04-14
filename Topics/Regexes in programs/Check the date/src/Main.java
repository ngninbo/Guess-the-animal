import java.util.*;

class Date {
    public static final String DAY_REGEX = "(0[1-9])|(1\\d)|(2\\d)|(3[0-1])";
    public static final String DELIMITER_REGEX = "[-\\/\\.]";
    public static final String MONTH_REGEX = "(0[1-9])|(1[0-2])";
    public static final String YEAR_REGEX = "(19|20)\\d{2}";

    private static final String DD_MM_YYYY_REGEX = "^(" + DAY_REGEX + ")" + DELIMITER_REGEX +
            "(" + MONTH_REGEX + ")" + DELIMITER_REGEX + "(" + YEAR_REGEX + ")$";
    private static final String YYYY_MM_DD_REGEX = "^(" + YEAR_REGEX + ")" + DELIMITER_REGEX +
            "(" + MONTH_REGEX + ")" + DELIMITER_REGEX + "(" + DAY_REGEX + ")$";

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();

        String dateRegex = String.join("|", YYYY_MM_DD_REGEX, DD_MM_YYYY_REGEX);

        System.out.println(date.matches(dateRegex) ? "Yes" : "No");
    }
}