package com.example.autores.web.dto

import com.example.autores.domain.Libro

data class AutorResponse(
    val id: Long,
    val nombre: String,
    val libros: MutableList<Libro> = mutableListOf()
)