package com.example.autores.web.dto

import com.example.autores.domain.Autor
import jakarta.validation.constraints.NotBlank


data class LibroRequest(
    @field:NotBlank
    val titulo: String,

    val autorId: Long // FK al autor
)
