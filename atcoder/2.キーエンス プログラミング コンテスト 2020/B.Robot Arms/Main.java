import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sn = new Scanner(System.in);
        Input inputN = InputParser.perse(sn, 1);
        int n = inputN.getInt(1, 1);

        Input input = InputParser.perse(sn, n);
        sn.close();

        List<Integer> x = input.getIntVerticalLine(1, 1, n);
        List<Integer> l = input.getIntVerticalLine(2, 1, n);

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < x.size(); i++) {
            Pair p = new Pair(x.get(i), l.get(i));
            list.add(p);
        }
        list = list.stream().sorted(Comparator.comparing(Pair::getKey)).collect(Collectors.toList());

        while (true) {
            int max = -1;
            int maxIndex = -1;
            for (int i = 0; i < list.size(); i++) {
                int effect = 0;
                for (int j = i - 1; j >= 0 ; j--) {
                    if (list.get(i).getKey() - list.get(i).getValue() < list.get(j).getKey() + list.get(j).getValue()) {
                        effect++;
                    }
                }

                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j).getKey() - list.get(j).getValue() < list.get(i).getKey() + list.get(i).getValue()) {
                        effect++;
                    }
                }
                if (max < effect) {
                    max = effect;
                    maxIndex = i;
                }
            }
            if (max == 0) {
                System.out.println(list.size());
                return;
            }
            list.remove(maxIndex);
        }
    }

    private static class Pair {
        private Integer key;
        private Integer value;

        Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        Integer getKey() {
            return key;
        }

        Integer getValue() {
            return value;
        }
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
