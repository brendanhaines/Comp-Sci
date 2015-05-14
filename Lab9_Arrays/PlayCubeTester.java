public class PlayCubeTester {
    public static void testGetCubeTosses() {
        System.out.println("================================"
            + "================================");
        System.out.println("Now testing static method \"getCubeTosses\""
            + "of class \"PlayCube\".");
        NumberCube cube = new NumberCube();

        int numTosses = 10;
        int[] results = PlayCube.getCubeTosses(cube, 10);

        System.out.print("Method getCubeTosses output: ");
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
        System.out.println();

        boolean check = numTosses == results.length;
        System.out.print("Correct # of tosses were rolled: " + check);
        System.out.println(" (expected " + numTosses + ")");

        System.out.println("================================"
            + "================================\n");
    }

    public static void testGetLongestRun() {
        System.out.println("================================"
            + "================================");
        System.out.println("Now testing static method \"getLongestRun\""
            + "of class \"PlayCube\".");

        int[] run = new int[] {
                1, 2, 6, 3, 5, 6, 1, 1, 1,
                1, 3, 5, 6, 7, 4, 4, 4, 4
            };

        System.out.print("Using data: ");
        for (int i = 0; i < run.length; i++) {
            System.out.print(run[i] + " ");
        }
        System.out.println();

        int index = PlayCube.getLongestRun(run);
        System.out.println("Result of getLongestRun: " + index + " ("
            + "expecting 6 or 14)");
        System.out.println("Method getLongestRun is working: "
            + (index == 6 || index == 14));
        System.out.println("================================"
            + "================================\n");
    }

    public static void main(String[] args) {
        testGetCubeTosses();
        testGetLongestRun();
    }
}