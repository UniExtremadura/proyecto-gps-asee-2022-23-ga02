package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.UserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(private val repository: UserRepository) {

    operator fun invoke(userId: Int?): Boolean {
        return repository.deleteUser(userId)
    }
}