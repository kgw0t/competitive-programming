import java.util.ArrayList;
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

        List<Integer> t = input.getIntVerticalLine(1, 1, n);
        List<Integer> x = input.getIntVerticalLine(2, 1, n);
        List<Integer> y = input.getIntVerticalLine(3, 1, n);

        int nowT = 0;
        int nowX = 0;
        int nowY = 0;

        for (int i = 0; i < t.size(); i++) {
            int time = t.get(i) - nowT;
            int dist = Math.abs(x.get(i) - nowX) + Math.abs(y.get(i) - nowY);
            int modTime = time - dist;
            if (modTime < 0 || modTime % 2 == 1) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
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
            for(int i = start; i < start + size; i++) {
                list.add(getInt(i, line));
            }
            return list;
        }
    }
}
