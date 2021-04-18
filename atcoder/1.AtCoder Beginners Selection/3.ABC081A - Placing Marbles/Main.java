import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static int INPUT_LINE = 1;

    public static void main(String[] args) throws Exception {
        Input input = InputParser.perse();
        String s = input.getString(1, 1);
        int s1 = s.charAt(0) - 48;
        int s2 = s.charAt(1) - 48;
        int s3 = s.charAt(2) - 48;
        System.out.println(s1 + s2 + s3);
    }

    private static class InputParser {
        static Input perse() {
            Input result = new Input();
            Scanner sn = new Scanner(System.in);
            while(INPUT_LINE-- > 0) {
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
            for(String str: args) {
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
    }
}
