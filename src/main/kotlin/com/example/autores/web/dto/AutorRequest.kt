package com.example.autores.web.dto

import com.example.autores.domain.Libro
import jakarta.validation.constraints.NotBlank

data class AutorRequest(
    @field:NotBlank val nombre: String,

    val libros: MutableList<Libro> = mutableListOf()
)
