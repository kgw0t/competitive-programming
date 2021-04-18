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

        Integer n = input.getInt(1, 1);

        int count = 0;
        int ketaN = String.valueOf(n).length();
        String strN = Integer.toString(n);
        char topN = strN.charAt(0);
        char bottomN = strN.charAt(strN.length() - 1);
        for (int a = 1; a <= n; a++) {
            String strA = Integer.toString(a);
            char topA = strA.charAt(0);
            char bottomA = strA.charAt(strA.length() - 1);

            if (bottomA == '0') {
                continue;
            }

            int start = 0;
            int ketaS = 0;
            System.out.println("topA : " + topA);
            System.out.println("bottomA : " + bottomA);
            if (topA == bottomA) {
                start = topA - 48;
                ketaS = 1;
            } else {
                start = (bottomA - 48) * 10 + topA - 48;
                ketaS = 2;
            }

            if (start < n) {
                count++;
            } else if (start == n) {
                count++;
                continue;
            } else {
                continue;
            }

            for (int i = 1; i <= ketaN - ketaS; i++) {
                if (ketaN == ketaS + i) {
                    if (topA < topN) {
                        count += Math.pow(10, i);
                    } else if (topA == topN) {

                    }
                } else {
                    count += Math.pow(10, i);
                }
                for (int j = 0; j < i; j++) {

                }
            }

            int
            int add = 1;
            while (true) {
                StringBuilder sb = new StringBuilder();
                sb.append(bottomA);
                for (int i = 0; i < add; i++) {
                    sb.append('9');
                }
                sb.append(topA);

            }
            System.out.println(start);
            System.out.println();

            int ketaS = String.valueOf(start).length();
            for (int i = 0; i < ketaN - ketaS; i++) {

            }
        }
        System.out.println(count);
    }

    private static class InputParser {
        static Input perse(Scanner sn, int line) {
            Input result = new Input();
            while (line-- > 0) {
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
