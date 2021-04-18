import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) throws Exception {
        Scanner sn = new Scanner(System.in);
        Input inputN = InputParser.perse(sn, 1);
        int n = inputN.getInt(1, 1);

        Input input = InputParser.perse(sn, n);
        sn.close();

        List<Integer> x = input.getIntVerticalLine(1, 1, n);
        List<Integer> l = input.getIntVerticalLine(2, 1, n);

        Integer[] a = new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            a[i] = 0;
        }

        int max = 1;
        int minIndex = 99999;
        int maxIndex = 0;
        for (int i = 0; i < x.size(); i++) {
            int left = Math.max(0, x.get(i) - l.get(i) + 1);
            int right = Math.min(99999, x.get(i) + l.get(i) - 1);
            for (int j = left; j <= right; j++) {
                a[j]++;
                if (max < a[j]) {
                    max = a[j];
                }
            }
            if (left < minIndex) {
                minIndex = left;
            }
            if (maxIndex < right) {
                maxIndex = right;
            }
        }

        int result = x.size();
        while (true) {
            if (max == 1) {
                break;
            }
            boolean isChain = false;
            for (int i = minIndex; i <= maxIndex; i++) {
                if (a[i] == max) {
                    a[i]--;
                    if (!isChain) {
                        result--;
                        isChain = true;
                    }
                } else if (isChain) {
                    isChain = false;
                }
            }
            max--;
        }
        System.out.println(result);
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

        List<Integer> getIntVerticalLine(int line, int start, int size) {
            List<Integer> list = new ArrayList<>();
            for (int i = start; i < start + size; i++) {
                list.add(getInt(i, line));
            }
            return list;
        }
    }
}
