package br.com.lucasmarciano.koinproject.data

/**
 * [Description]
 *
 * @project KoinProject
 * @create_at 15/02/19
 * @author lucasmarciano
 */
class DataRepositoryFactory(
    private val localDataSource: DataRepository,
    private val remoteDataSource: DataRepository
) {

    fun retrieveRemoteSource(): DataRepository {
        return localDataSource
    }

    fun retrieveLocalSource(): DataRepository {
        return remoteDataSource

    }
}