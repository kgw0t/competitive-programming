import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static int INPUT_LINE = 3;

    public static void main(String[] args) throws Exception {
        Input input = InputParser.perse();
        Integer a = input.getInt(1, 1);
        Integer b = input.getInt(2, 1);
        Integer c = input.getInt(2, 2);
        String s = input.getString(3, 1);
        System.out.println((a + b + c) + " " + s);
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
            inputs = new LinkedHashMap<>();
            inputs.put(now, new LinkedHashMap<>());
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
            inputs.put(++now, new LinkedHashMap<>());
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