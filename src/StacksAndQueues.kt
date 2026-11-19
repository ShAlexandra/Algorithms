/**
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 *
 * Example 5:
 *
 * Input: s = "([)]"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
fun isValid(s: String): Boolean {
        val sStack = mutableListOf<Char>()
        for(symbol in s) {
            if(symbol == '(' || symbol == '{' || symbol == '[') {
                sStack.add(symbol)
            } else {
                if(sStack.isNotEmpty()) {
                    if(symbol == ')') {
                        if(sStack.removeLast() != '(') return false
                    }
                    if(symbol == '}') {
                        if(sStack.removeLast() != '{') return false
                    }
                    if(symbol == ']') {
                        if(sStack.removeLast() != '[') return false
                    }
                } else return false
            }
        }
        return (sStack.isEmpty())
    }

/**
 * 155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int value) pushes the element value onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
class MinStack() {
    data class StackItem(val value: Int = 0, val min: Int = 0)
    val minStack = mutableListOf<StackItem>()

    fun push(value: Int) {
        var min = getMin()
        if(value<min) min = value
        minStack.add(StackItem(value, min))
    }

    fun pop() {
        minStack.removeLast()
    }

    fun top(): Int {
        return minStack.last().value
    }

    fun getMin(): Int {
        if(minStack.isEmpty()) return Integer.MAX_VALUE
        return minStack.last().min
    }

}

/**
 * 921. Minimum Add to Make Parentheses Valid
 *
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "())"
 * Output: 1
 * Example 2:
 *
 * Input: s = "((("
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] is either '(' or ')'.
 */
fun minAddToMakeValid(s: String): Int {
    var openP = 0
    var closeP = 0
    for(elem in s) {
        when(elem) {
            '(' -> openP++
            ')' -> {
                if(openP>0) openP--
                else closeP++
            }
        }
    }
    return openP+closeP
}