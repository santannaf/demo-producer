package com.example.demoappproducer

import com.github.avrokotlin.avro4k.Avro
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class TodoProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    private val avro: Avro
) : TodoAny{
    override fun publish(message: Todo) {

//        val msg = avro

        kafkaTemplate.send("topic-a", message).handle { _, error ->
            if (error != null) {
                throw error
            }
        }

    }
}