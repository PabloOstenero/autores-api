package com.example.autores.web.mapper

import com.example.autores.domain.Libro
import com.example.autores.web.dto.LibroRequest
import com.example.autores.web.dto.LibroResponse

object LibroMapper {
    fun toEntity(req: LibroRequest) =
        Libro(
            titulo = req.titulo
        )

    fun toResponse(libro: Libro): LibroResponse =
        LibroResponse(
            id = libro.id!!,
            titulo = libro.titulo,
            autorId = libro.autor?.id
        )

    fun merge(entity: Libro, req: LibroRequest) = entity.copy(
        titulo = req.titulo
    )
}
