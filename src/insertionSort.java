import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Input {
    int a;
    int b;

    Input(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString() {
        return "Input{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

public class insertionSort {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        List<Input> numbers = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            numbers.add(new Input(getField(line), getFieldSec(line)));
        }
        reader.close();
        System.out.println(Arrays.toString(numbers.toArray()));
        FileWriter writer = new FileWriter("output.txt");
        for (int i = 1; i < numbers.size(); i++) {
            int val = numbers.get(i).a;
            int valb = numbers.get(i).b;
            int hole = i - 1;
            while (hole >= 0 && numbers.get(hole).a < val) {
                numbers.set(hole + 1, numbers.get(hole));
                hole = hole - 1;
            }
            numbers.set(hole + 1, new Input(val, valb));
        }

        System.out.println(Arrays.toString(numbers.toArray()));
        for (Input number : numbers) {
            writer.write(number.a + " " + number.b);
            writer.write('\n');
        }
        writer.close();
    }

    private static int getField(String line) {
        return Integer.parseInt(line.split("\t")[0]);//extract value you want to sort on
    }

    private static int getFieldSec(String line) {
        return Integer.parseInt(line.split("\t")[1]);//extract value you want to sort on
    }
}