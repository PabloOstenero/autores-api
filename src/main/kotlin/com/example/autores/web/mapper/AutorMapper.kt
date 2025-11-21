package com.example.autores.web.mapper

import com.example.autores.domain.Autor
import com.example.autores.web.dto.AutorResponse
import com.example.autores.web.dto.AutorRequest

object AutorMapper {
    fun toEntity(req: AutorRequest) = Autor(
        nombre = req.nombre
    )

    fun toResponse(a: Autor) = AutorResponse(
        id = a.id!!,
        nombre = a.nombre,
        libros = a.libros
    )

    fun merge(entity: Autor, req: AutorRequest) = entity.copy(
        nombre = req.nombre
    )
}