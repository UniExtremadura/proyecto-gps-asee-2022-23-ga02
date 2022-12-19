package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.Entity.UserEntity
import es.unex.trackstone10.roomdb.UserRepository
import javax.inject.Inject

class ModifyUserUseCase @Inject constructor(private val repository: UserRepository) {

    operator fun invoke(user: UserEntity): Boolean {
        return repository.modifyUser(user)
    }
}