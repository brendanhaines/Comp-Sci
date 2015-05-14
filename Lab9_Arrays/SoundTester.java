import java.lang.reflect.Field;
import java.util.Arrays;

public class SoundTester {
    public static void testLimitAmplitude() {
        try {
            System.out.println("================================"
                               + "================================");
            System.out.println("Now testing method \"limitAmplitude\" of class "
                               + "\"Sound\".");
            
            Sound sound = new Sound();
            
            Field f = sound.getClass().getDeclaredField("samples");
            f.setAccessible(true);
            
            int[] seed = new int[] {
                40, 2532, 17, -2300, -17, -4000, 2000,
                1048, -420, 33, 15, -32, 2030, 3223
            };
            
            f.set(sound, seed);
            
            System.out.println("Using \"limitAmplitude(2000)\" as test:\n");
            System.out.print("Before: ");
            for (int i = 0; i < seed.length; i++) {
                System.out.print(seed[i] + " ");
            }
            System.out.println();
            
            int changed = sound.limitAmplitude(2000);
            int[] results = int[].class.cast(f.get(sound));
            
            System.out.print("After:  ");
            for (int i = 0; i < results.length; i++) {
                System.out.print(results[i] + " ");
            }
            System.out.println();
            
            int[] expected = new int[] {
                40, 2000, 17, -2000, -17, -2000, 2000,
                1048, -420, 33, 15, -32, 2000, 2000
            };
            
            System.out.print("Expctd: ");
            for (int i = 0; i < expected.length; i++) {
                System.out.print(expected[i] + " ");
            }
            System.out.println("\n");
            
            boolean equal = Arrays.equals(results, expected);
            System.out.println("Number of changed elements: " + changed
                               + " (expecting 5)");
            System.out.println("Method limitAmplitude is working: " + equal);
            System.out.println("================================"
                               + "================================\n");
        } catch (IllegalAccessException e) {
            System.out.println("Error: Make sure the variable \"samples\" is"
                               + "not final.");
        } catch (NoSuchFieldException e) {
            System.out.println("Error: The variable \"samples\" is missing.");
        }
    }
    
    public static void testTrimSilenceFromBeginning() {
        try {
            System.out.println("================================"
                               + "================================");
            System.out.println("Now testing method \"trimSilenceFromBeginning\""
                               + "of class \"Sound\".");
            
            Sound sound = new Sound();
            
            Field f = sound.getClass().getDeclaredField("samples");
            f.setAccessible(true);
            
            int[] seed = new int[] {
                0, 0, 0, 0, -14, 0, -35, -39,
                0, -7, 16, 32, 37, 29, 0, 0
            };
            
            f.set(sound, seed);
            
            System.out.println("Using \"trimSilenceFromBeginning()\" as test:");
            System.out.print("Before: ");
            for (int i = 0; i < seed.length; i++) {
                System.out.print(seed[i] + " ");
            }
            System.out.println();
            
            sound.trimSilenceFromBeginning();
            int[] results = int[].class.cast(f.get(sound));
            
            System.out.print("After:  ");
            for (int i = 0; i < results.length; i++) {
                System.out.print(results[i] + " ");
            }
            System.out.println();
            
            int[] expected = new int[] {
                -14, 0, -35, -39, 0, -7,
                16, 32, 37, 29, 0, 0
            };
            
            System.out.print("Expctd: ");
            for (int i = 0; i < expected.length; i++) {
                System.out.print(expected[i] + " ");
            }
            System.out.println("\n");
            
            boolean equal = Arrays.equals(results, expected);
            System.out.println("Method trimSilenceFromBeginning is working: "
                               + equal);
            System.out.println("================================"
                   + "================================\n");
        } catch (IllegalAccessException e) {
            System.out.println("Error: Make sure the variable \"samples\" is"
                               + "not final.");
        } catch (NoSuchFieldException e) {
            System.out.println("Error: The variable \"samples\" is missing.");
        }
    }
    
    public static void main(String[] args) {
        testLimitAmplitude();
        testTrimSilenceFromBeginning();
    }
}