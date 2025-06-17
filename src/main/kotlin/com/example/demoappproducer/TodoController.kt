package com.example.demoappproducer

import org.slf4j.LoggerFactory
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
    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun publisherTodo() {
        logger.info("receive request POST create todo()")
        return todoAny.publish(
            Todo(
                id = Random.nextLong(1, 10001),
                code = UUID.randomUUID().toString()
            )
        )
    }
}
