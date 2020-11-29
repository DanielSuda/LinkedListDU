private val value: E,
private val next: LinkedList<E>?
) : List<E> {
    override fun get(index: Int): E {
        return when {
            index == 0 -> value
            next != null -> next[index - 1]
            else -> throw ArrayIndexOutOfBoundsException()
        }
    }

    override val size: Int
    get() {
        if (next == null) return 1
        return 1 + next.size
    }

    override fun indexOf(element: E): Int {
        if (value == element) return 0
        else if (next != null) {
            val index = next.indexOf(element)
            if (index != -1) return index + 1
        }
        return -1
    }

    override fun contains(element: E): Boolean = indexOf(element) >= 0

    override fun lastIndexOf(element: E): Int {
        // null | - 1 | 0++++
        val lastIndexFoundByChildren = when {
            next != null -> next.lastIndexOf(element)
            else -> -1
        }

        return when (lastIndexFoundByChildren) {
            -1 -> when (element) {
                value -> 0
                else -> -1
            }
            else -> lastIndexFoundByChildren + 1
        }
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<E> {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<E> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<E> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<E> {
        TODO("Not yet implemented")
    }

}


fun main() {
    val a = LinkedList(1, LinkedList(2, LinkedList(3, LinkedList(4, LinkedList(1, null)))))
    println(a.lastIndexOf(2))
}