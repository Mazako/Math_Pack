import java.util.*;

public class ONP {
    public static List<String> operators = List.of("+", "-", "*", "/");
    public static double equation(String onp) {
        Deque<Double> stack = new ArrayDeque<>();
        Queue<String> data = new LinkedList<>(Arrays.asList(onp.split(" ")));
        while (!data.isEmpty()) {
            String element = data.poll();
            if (operators.contains(element)) {
                double a = stack.pollLast();
                double b = stack.pollLast();
                stack.add(operation(a,b,element));
            }
            else
                stack.add(Double.parseDouble(element));
        }
        return stack.poll();
    }

    private static Double operation(double a, double b, String element) {
        return switch (element) {
            case "+" -> b + a;
            case "-" -> b - a;
            case "*" -> b * a;
            case "/" -> b / a;
            default -> null;
        };
    }
}
