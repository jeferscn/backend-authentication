package br.pucpr.authserver.users

import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun save(user: User) {
        userRepository.save(user)
    }

    fun findAll(sortDir: String?): List<User>? {
        return userRepository.findAll(sortDir)
    }

    fun findByIdOrNull(id: Long): User? {
        return userRepository.findByIdOrNull(id)
    }

    fun deleteUserById(id: Long): User? {
        return userRepository.deleteById(id)
    }
}