package com.example.demoappproducer

import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val id: Long,
    val code: String
)
