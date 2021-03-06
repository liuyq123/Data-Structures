import java.util.ArrayList;
import java.util.List;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        if (asciis.length == 0) {
            return asciis;
        }
        
        // compute the maximum length of those strings
        int max = asciis[0].length();
        for (int i = 0; i < asciis.length; i++) {
            if (max < asciis[i].length()) {
                max = asciis[i].length();
            }
        }

        String[] toSort = asciis.clone();
        for (int i = max - 1; i >= 0; i--) {
            sortHelperLSD(toSort, i);
        }

        return toSort;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        int radix = 256;

        int[] counts = new int[radix];

        for (String s : asciis) {
            if (s.length() - 1 < index) {
                counts[0]++;
            } else {
                counts[s.charAt(index)]++;
            }
        }

        int[] starts = new int[radix];
        int pos = 0;
        for (int i = 0; i < starts.length; i++) {
            starts[i] = pos;
            pos += counts[i];
        }

        String[] tmp = asciis.clone();
        for (String s : tmp) {
            if (s.length() - 1 < index) {
                int place = starts[0];
                asciis[place] = s;
                starts[0]++;
            } else {
                int place = starts[s.charAt(index)];
                asciis[place] = s;
                starts[s.charAt(index)]++;
            }
        }
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
}
