import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class SelectionSort {


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
        List<Integer> numbers = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            numbers.add(Integer.parseInt(line));
        }
        reader.close();
        Integer[] inputArray = numbers.toArray(new Integer[numbers.size()]);
        mySelectionSort(inputArray);
        FileWriter writer = new FileWriter("output.txt");

        for (Integer i : inputArray) {
            writer.write(i + " ");
            writer.write('\n');
        }
        writer.close();
    }

    private static void mySelectionSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[index])
                    index = j;

            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
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

