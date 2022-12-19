package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: UserRepository) {

    operator fun invoke(query1: String, query2: String) = repository.login(query1, query2)
}