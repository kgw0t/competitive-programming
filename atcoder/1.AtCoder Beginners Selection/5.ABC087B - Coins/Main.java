import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static int INPUT_LINE = 4;

    public static void main(String[] args) throws Exception {
        Input input = InputParser.perse();
        int A = input.getInt(1, 1);
        int B = input.getInt(2, 1);
        int C = input.getInt(3, 1);
        int X = input.getInt(4, 1);

        int count = 0;
        for (int a = 0; a <= A; a++) {
            int priceA = a * 500;
            if (priceA > X) {
                break;
            }
            if (priceA == X) {
                count++;
                break;
            }
            for (int b = 0; b <= B; b++) {
                int priceAB = priceA + b * 100;
                if (priceAB > X) {
                    break;
                }
                if (priceAB == X) {
                    count++;
                    break;
                }

                int need50 = (X - priceAB) / 50;
                if (need50 <= C) {
                    count++;
                }
            }
        }
        System.out.println(count);
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
