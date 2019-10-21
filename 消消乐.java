你有一个string， 如果一个字母连续出现3次以上，消除他们，for example, abbb return a,,, cabbbaa return c.

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        // int a = scan.nextInt();
        // // Complete this line
        // // Complete this line

        // System.out.println(a);
        // Complete this line
        // Complete this line

        System.out.println(process("aabbbfa"));
    }

    public static String process(String str) {
        if(str == null) {
            return "";
        }
        Stack<int[]> stack = new Stack<>();
        int start = 0;
        while (start < str.length()) {
            int end = start + 1;
            if (end < str.length() && str.charAt(start) == str.charAt(end)) {
                while (end < str.length() && str.charAt(end) == str.charAt(start)) {
                    end++;
                }
            }
            int[] num = new int[]{(int)(str.charAt(start) - 'a'), end - start};
            System.out.println("num[0]: " + num[0] + " num[1]: " + num[1]);
            if (!stack.isEmpty()) {
                int[] top = stack.peek();
                if (top[0] == num[0]) {
                    if (top[1] + num[1] >= 3) {
                        stack.pop();
                        start = end;
                        continue;
                    } else {
                        top[1] += num[1];
                    }
                }
            }

            if (end - start < 3) {
                System.out.println("start: " + start + " end: " + end);
                System.out.println(num[0] + " " + num[1]);
                stack.push(num);
            }
            System.out.println("1start: " + start + " 1end: " + end);
            start = end;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            for (int i = 0; i < cur[1]; i++) {
                sb.insert(0, (char)('a' + cur[0]));
            }
        }
        return sb.toString();
    }
}

