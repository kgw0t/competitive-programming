import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static int INPUT_LINE = 1;

    public static void main(String[] args) throws Exception {
        Input input = InputParser.perse();
        int n = input.getInt(1, 1);
        int a = input.getInt(1, 2);
        int b = input.getInt(1, 3);

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int sumDigits = sumDigits(i);
            if (a <= sumDigits && sumDigits <= b) {
                count += i;
            }
        }
        System.out.println(count);
    }

    private static int sumDigits(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }


    private static class InputParser {
        static Input perse() {
            Input result = new Input();
            Scanner sn = new Scanner(System.in);
            while (INPUT_LINE-- > 0) {
                String[] args = sn.nextLine().split(" ");
                result.addAll(args);
            }
            sn.close();
            return result;
        }
    }

    private static class Input {
        private Map<Integer, Map<Integer, String>> inputs;
        private int now = 1;
        private int innerNext = 1;

        Input() {
            inputs = new HashMap<>();
            inputs.put(now, new HashMap<>());
        }

        void addAll(String[] args) {
            for (String str : args) {
                add(str);
            }
            next();
        }

        void add(String str) {
            inputs.get(now).put(innerNext++, str);
        }

        void next() {
            inputs.put(++now, new HashMap<>());
            innerNext = 1;
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
            return inputs.get(i).entrySet().stream().map(e -> Integer.parseInt(e.getValue()))
                    .collect(Collectors.toList());
        }
    }
}
