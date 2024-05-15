package br.pucpr.authserver.users

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @PostMapping()
    fun insert(@RequestBody @Valid user: UserRequest) {
        userService.save(user.toUser())
    }

    @GetMapping()
    fun findAll(@RequestParam("sortDir", required = false) sortDir: String?) =
        userService.findAll(sortDir)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()


    @GetMapping("/{id}")
    fun findByIdOrNull(@PathVariable(value="id") id: Long) =
        userService.findByIdOrNull(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value="id") id: Long) =
        userService.deleteUserById(id)?.let {
            ResponseEntity.ok("")
        } ?: ResponseEntity.notFound().build()
}