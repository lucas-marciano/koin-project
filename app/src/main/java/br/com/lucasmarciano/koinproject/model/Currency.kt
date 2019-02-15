package br.com.lucasmarciano.koinproject.model

/**
 * [Description]
 *
 * @project KoinProject
 * @create_at 14/02/19
 * @author lucasmarciano
 */
data class Currency(
    val id: Int,
    val name: String,
    val symbol: String,
    val slug: String
)