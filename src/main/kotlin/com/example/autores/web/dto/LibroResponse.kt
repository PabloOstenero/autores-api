package com.example.autores.web.dto

data class LibroResponse(
    val id: Long,
    val titulo: String,
    val autorId: Long? = null  // FK al autor
)