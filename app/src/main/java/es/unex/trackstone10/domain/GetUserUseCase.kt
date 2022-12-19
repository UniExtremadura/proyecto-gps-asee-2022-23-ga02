package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.Entity.UserEntity
import es.unex.trackstone10.roomdb.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserRepository) {

    operator fun invoke(userId: Int): UserEntity {
        return repository.getUser(userId)
    }
}