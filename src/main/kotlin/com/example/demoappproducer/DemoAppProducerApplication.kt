package com.example.demoappproducer

import com.tanna.annotation.EnabledArchKafka
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy
@EnabledArchKafka(appName = "demo-app-producer")
@SpringBootApplication(scanBasePackages = ["com"])
class DemoAppProducerApplication

fun main(args: Array<String>) {
	runApplication<DemoAppProducerApplication>(*args)
}
