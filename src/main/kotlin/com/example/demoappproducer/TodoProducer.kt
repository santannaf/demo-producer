package com.example.demoappproducer

import com.github.avrokotlin.avro4k.Avro
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class TodoProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    private val avro: Avro
) : TodoAny {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun publish(message: Todo) {
        val bytes = avro.toRecord(Todo.serializer(), message)
        kafkaTemplate.send("topic-a", bytes).handle { _, error ->
            if (error != null) {
                throw error
            } else {
                logger.info("m=publish, stage=finished, i=publish_success, msg=Mensagem enviada com sucesso!")
            }
        }
    }
}
