package com.example.demoappproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com"])
class DemoAppProducerApplication

fun main(args: Array<String>) {
	runApplication<DemoAppProducerApplication>(*args)
}
