package utilities;

import java.util.HashMap;
import java.util.LinkedList;

public class MultiBracketValidation {
    public static boolean multiBracketValidation(String input) {
        HashMap<String, String> brackets = new HashMap<>();
        brackets.put("}", "{");
        brackets.put("]", "[");
        brackets.put(")", "(");
        LinkedList<String> stack = new LinkedList<>();

        // adds opening brackets to top of stack
        // checks closing brackets against most recent opening bracket in stack using bracket HashMap
        // ignores all other characters
        for (String letter : input.split("")) {
            if (brackets.containsKey(letter)) {
                if (!brackets.get(letter).equals(stack.removeFirst())) return false;
            } else if (brackets.containsValue(letter)) {
                stack.addFirst(letter);
            }
        }

        // if the stack is empty, it either means the string was empty, and returns true
        // or it means all the opening brackets had matching closing brackets, and returns true
        // if it's not empty, then there were opening brackets stranded, and it returns false
        return stack.isEmpty();
    }
}
