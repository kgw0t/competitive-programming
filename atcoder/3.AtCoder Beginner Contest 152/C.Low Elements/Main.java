import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sn = new Scanner(System.in);
        Input input = InputParser.perse(sn, 2);
        sn.close();

        Integer n = input.getInt(0, 0);
        List<Integer> p = input.getIntLine(1);

        int min = p.get(0);
        int count = 1;
        for (int i = 1; i < p.size(); i++) {
            if (p.get(i) <= min) {
                count++;
                min = p.get(i);
            }
        }

        System.out.println(count);
    }

    private static class InputParser {
        static Input perse(Scanner sn, int line) {
            Input result = new Input();
            while (line-- > 0) {
                String[] args = sn.nextLine().split(" ");
                result.add(args);
            }
            return result;
        }
    }

    private static class Input {
        private List<List<String>> inputs;

        Input() {
            inputs = new ArrayList<>();
        }

        void add(String[] args) {
            inputs.add(Arrays.asList(args));
        }

        String getString(int i, int j) {
            return inputs.get(i).get(j);
        }

        int getInt(int i, int j) {
            return Integer.parseInt(getString(i, j));
        }

        double getDouble(int i, int j) {
            return Double.parseDouble(getString(i, j));
        }

        List<Integer> getIntLine(int i) {
            return inputs.get(i).stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        }

        List<Integer> getIntVerticalLine(int line, int start, int size) {
            List<Integer> list = new ArrayList<>();
            for (int i = start; i < start + size; i++) {
                list.add(getInt(i, line));
            }
            return list;
        }
    }
}