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
 * 232. Implement Queue using Stacks
 *
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 *
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 *
 *
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */
class MyQueue() {

    val stackPush = mutableListOf<Int>()
    val stackPop = mutableListOf<Int>()

    fun push(x: Int) = stackPush.add(x)

    fun pop(): Int {
        if(stackPop.isEmpty()) moveElements()
        return stackPop.removeLast()
    }

    fun peek(): Int {
        if(stackPop.isEmpty()) moveElements()
        return stackPop.last()
    }

    fun empty(): Boolean = stackPush.isEmpty() && stackPop.isEmpty()

    fun moveElements() {
        while(stackPush.isNotEmpty()) {
            stackPop.add(stackPush.removeLast())
        }
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

/**
 * 856. Score of Parentheses
 *
 * Given a balanced parentheses string s, return the score of the string.
 *
 * The score of a balanced parentheses string is based on the following rule:
 *
 * "()" has score 1.
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: 1
 * Example 2:
 *
 * Input: s = "(())"
 * Output: 2
 * Example 3:
 *
 * Input: s = "()()"
 * Output: 2
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 50
 * s consists of only '(' and ')'.
 * s is a balanced parentheses string.
 */
fun scoreOfParentheses(s: String): Int {
    val stack = mutableListOf<Int>()
    var current = 0


    for(item in s) {
        when(item) {
            '(' -> {
                stack.add(current)
                current = 0
            }
            ')' -> {
                if(current==0) {
                    current = 1 + stack.removeLast()
                } else {
                    current = current*2+stack.removeLast()
                }
            }
        }
    }
    return current
}