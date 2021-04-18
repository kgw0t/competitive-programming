import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sn = new Scanner(System.in);
        Input input = InputParser.perse(sn, 1);
        sn.close();

        int n = input.getInt(1, 1);
        int y = input.getInt(1, 2);

        for (int i = 0; i <= n; i++) {
            int p10000 = i * 10000;
            int r10000 = n - i;
            if (r10000 == 0 && p10000 == y) {
                System.out.println(i + " 0 0");
                return;
            }
            for (int j = 0; j <= r10000; j++) {
                int p5000 = j * 5000;
                int r5000 = r10000 - j;
                if (r5000 == 0 && p10000 + p5000 == y) {
                    System.out.println(i + " " + j + " 0");
                    return;
                } else if (p10000 + p5000 + r5000 * 1000 == y) {
                    System.out.println(i + " " + j + " " + r5000);
                    return;
                }
            }
        }
        System.out.println("-1 -1 -1");
    }

    private static class InputParser {
        static Input perse(Scanner sn, int loop) {
            Input result = new Input();
            while (loop-- > 0) {
                String[] args = sn.nextLine().split(" ");
                result.addAll(args);
            }
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

        List<Integer> getIntVerticalLine(int start, int size) {
            List<Integer> list = new ArrayList<>();
            for(int i = start; i < start + size; i++) {
                list.add(getInt(i, 1));
            }
            return list;
        }
    }
}
