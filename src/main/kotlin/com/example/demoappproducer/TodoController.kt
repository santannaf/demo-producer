package com.example.demoappproducer

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import kotlin.random.Random

@RestController
@RequestMapping("/todos")
class TodoController(
    private val todoAny: TodoAny
) {
    @PostMapping
    fun publisherTodo() {
        return todoAny.publish(
            Todo(
                id = Random.nextLong(1, 10001),
                code = UUID.randomUUID().toString()
            )
        )
    }
}
