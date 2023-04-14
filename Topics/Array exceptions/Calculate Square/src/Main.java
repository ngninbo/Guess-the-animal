
class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {

        try {
            int element = array[index];

            System.out.println(element * element);
        } catch (Exception e) {
            System.out.println("Exception!");
        }
    }
}