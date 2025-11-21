package com.example.autores.web.dto

import jakarta.validation.constraints.NotBlank

data class AutorRequest(
    @field:NotBlank val nombre: String
)
