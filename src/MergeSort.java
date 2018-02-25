import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class MergeSort {

    public static void main(String[] args) throws Exception {
        MergeSort pb = new MergeSort();
        BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
        List<Integer> numbers = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            numbers.add(Integer.parseInt(line));
        }
        reader.close();
        Integer[] inputArray = numbers.toArray(new Integer[numbers.size()]);
        pb.mergeSort(inputArray, 0, inputArray.length - 1);
        FileWriter writer = new FileWriter("output.txt");

        for (Integer i : inputArray) {
            writer.write(i + " ");
            writer.write('\n');
        }
        writer.close();
    }

    private void mergeSort(Integer[] arr, int lowest, int n) {
        int low = lowest;
        if (low >= n) {
            return;
        }

        int middle = (low + n) / 2;
        mergeSort(arr, low, middle);
        mergeSort(arr, middle + 1, n);
        int end_low = middle;
        int start_high = middle + 1;
        while ((lowest <= end_low) && (start_high <= n)) {
            if (arr[low] < arr[start_high]) {
                low++;
            } else {
                int Temp = arr[start_high];
                System.arraycopy(arr, low, arr, low + 1, start_high - low);
                arr[low] = Temp;
                low++;
                end_low++;
                start_high++;
            }
        }

    }
}

/*

input.txt file

12
41
9
99
57
69
5
26
95
38

output.txt file
5
9
12
26
38
41
57
69
95
99
 */

