package rpn;
import java.util.*;

public class rpn {public String calcolaRPN(String equazione) throws Exception {
    Stack<Float> output = new Stack<>();

    String[] tokens = equazione.trim().split("\\s+");

    for (String s : tokens) {
        if (isOperator(s)) {
            float n2 = output.pop();
            float n1 = output.pop();
            output.push(Float.valueOf(opFunction(s, n1, n2)));
        } else {
            output.push(Float.parseFloat(s));
        }
    }
    return Float.toString(output.peek());
}
    private String opFunction(String op, float n1, float n2) throws Exception {
        switch (op) {
            case "":
                return Float.toString(n1 * n2);
            case "/":
                if (n2 == 0) {
                    throw new Exception("Divisione per 0");
                }
                return Float.toString(n1 / n2);
            case "+":
                return Float.toString(n1 + n2);
            case "-":
                return Float.toString(n1 - n2);
            default:
                throw new Exception("Operatore non valido: " + op);
        }
    }

    private boolean isOperator(String s) {
        return s.matches("[/+-]");
    }

    public String traduciRPN(String input) throws Exception {
        List<String> ris = new ArrayList<>();
        Stack<String> output = new Stack<>();
        Stack<String> operandi = new Stack<>();

        String[] tokens = input.trim().split("\\s+");

        for (String s : tokens) {
            if (!isOperator(s) && !s.equals("(") && !s.equals(")")) {
                output.push(s);
            } else if (s.equals("(")) {
                operandi.push(s);
            } else if (s.equals(")")) {
                while (!operandi.isEmpty() && !operandi.peek().equals("(")) {
                    output.push(operandi.pop());
                }
                operandi.pop(); // Rimuovo la parentesi aperta
            } else if (isOperator(s)) {
                while (!operandi.isEmpty() && precedenza(operandi.peek(), s)) {
                    output.push(operandi.pop());
                }
                operandi.push(s);
            }
        }

        while (!operandi.isEmpty()) {
            output.push(operandi.pop());
        }

        StringBuilder result = new StringBuilder();
        for (String item : output) {
            result.append(item).append(" ");
        }

        return result.toString().trim();
    }

    private boolean precedenza(String op1, String op2) {
        if ((op1.equals("")  || op1.equals("/")) && (op2.equals("+") ||  op2.equals("-"))) {
            return true;
        }
        return false;
    }

}