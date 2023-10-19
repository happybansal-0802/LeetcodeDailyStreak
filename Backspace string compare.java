class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Use stacks to simulate the typing process
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        // Process string S
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stackS.push(c);  // Push character onto the stack
            } else if (!stackS.isEmpty()) {
                stackS.pop();  // Pop if it's a backspace and the stack is not empty
            }
        }

        // Process string T
        for (char c : t.toCharArray()) {
            if (c != '#') {
                stackT.push(c);  // Push character onto the stack
            } else if (!stackT.isEmpty()) {
                stackT.pop();  // Pop if it's a backspace and the stack is not empty
            }
        }

        // Compare the contents of the two stacks
        return stackS.equals(stackT);
    }
}
