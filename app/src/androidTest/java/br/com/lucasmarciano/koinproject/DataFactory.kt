package br.com.lucasmarciano.koinproject

import java.util.concurrent.ThreadLocalRandom

/**
 * [Description]
 *
 * @project KoinProject
 * @create_at 16/02/19
 * @author lucasmarciano
 */
object DataFactory {
    fun randomUuid(): String {
        return java.util.UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }
}