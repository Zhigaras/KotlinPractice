import java.util.Stack

class Stack<T> {
    private var stack = Stack<T>()

    fun push(item: T) {
        stack.add(item)
    }

    fun pop(): T? {
        return if (stack.isEmpty()) null
        else stack.pop()
    }

    fun isNotEmpty(): Boolean {
        return stack.isNotEmpty()
    }

    fun clear() {
        return stack.clear()
    }
}