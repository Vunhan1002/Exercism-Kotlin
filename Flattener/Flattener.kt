object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        val out = mutableListOf<Any>()

        fun dfs(x: Any?) {
            when (x) {
                null -> return
                is Collection<*> -> {
                    // safe cast sang Collection<Any?> để đệ quy
                    (x as Collection<Any?>).forEach { dfs(it) }
                }
                else -> out += x
            }
        }

        source.forEach { dfs(it) }
        return out
    }
}
