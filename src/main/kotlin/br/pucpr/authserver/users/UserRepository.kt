package br.pucpr.authserver.users

import org.springframework.stereotype.Component

@Component
class UserRepository {

    private var lastId: Long = -1
    private val users = mutableMapOf<Long, User>()

    fun save(user: User) {
        val id = user.id
        if (id == null) {
            lastId += 1
            user.id = lastId
            users[lastId] = user
        } else {
            users[id] = user
        }
        return
    }

    fun findAll(sortDir: String?): List<User>? {
        if (sortDir.equals("ASC", ignoreCase = true)) {

            return users.values.toList().sortedBy { it.id }
        } else if (sortDir.equals("DESC", ignoreCase = true)) {

            return users.values.toList().sortedByDescending { it.id }
        } else if (sortDir.isNullOrBlank()) {

            return users.values.toList()
        }

        return null
    }

    fun findByIdOrNull(id: Long) = users[id]

    fun deleteById(id: Long) = users.remove(id)

}