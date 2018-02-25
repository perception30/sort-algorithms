import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class QuickSort {

    public static void main(String[] args) throws Exception {
        QuickSort pb = new QuickSort();
        BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
        List<Integer> numbers = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            numbers.add(Integer.parseInt(line));
        }
        reader.close();
        Integer[] inputArray = numbers.toArray(new Integer[numbers.size()]);
        pb.sort(inputArray, 0, inputArray.length - 1);
        FileWriter writer = new FileWriter("output.txt");

        for (Integer i : inputArray) {
            writer.write(i + " ");
            writer.write('\n');
        }
        writer.close();
    }

    private int partition(Integer[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private void sort(Integer[] array, int low, int high) {
        if (low < high) {

            int pi = partition(array, low, high);

            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
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

