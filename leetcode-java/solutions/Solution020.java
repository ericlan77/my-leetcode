package solutions;
import java.util.HashMap;
import java.util.Stack;

public class Solution020 {
    static HashMap<Character, Character> map = new HashMap<>(){{
        put('}','{');
        put(']','[');
        put(')','(');
    }};

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
            if (!map.containsKey(s.charAt(i)))
                stack.push(s.charAt(i));
            else
                // if the stack is already empty, then only right bracket
                if(stack.isEmpty() || (!map.get(s.charAt(i)).equals(stack.pop())))
                    return false;
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()()((()))"));
    }
}
