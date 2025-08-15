class Deque<T> {
    private var first: Node<T>? = null
    private var last: Node<T>? = null

    class Node<T>(
        var value: T? = null,
        var next: Node<T>? = null,
        var prev: Node<T>? = null,
    )

    fun push(value: T) {
        val l = last
        val newNode = Node(prev = l, value = value)

        last = newNode

        if (l == null) first = newNode else l.next = newNode
    }

    fun pop(): T? {
        val l = last ?: throw NoSuchElementException()
        val value = l.value
        val next = l.prev

        last = next

        if (next == null) first = null else next.prev = null

        return value
    }

    fun unshift(value: T) {
        val f = first
        val newNode = Node(value = value, next = f)

        first = newNode

        if (f == null) last = newNode else f.prev = newNode
    }

    fun shift(): T? {
        val f = first ?: throw NoSuchElementException()
        val value = f.value
        val next = f.next

        first = next

        if (next == null) last = null else next.prev = null

        return value
    }
}