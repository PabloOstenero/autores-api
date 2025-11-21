package com.example.autores.service

import com.example.autores.domain.Autor
import com.example.autores.repository.AutorRepository
import com.example.autores.web.dto.AutorRequest
import com.example.autores.web.mapper.AutorMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AutorService(private val repo: AutorRepository) {

    @Transactional(readOnly = true)
    fun list(): List<Autor> = repo.findAll().sortedBy{ it.id }

    @Transactional(readOnly = true)
    fun get(id: Long): Autor =
        repo.findById(id).orElseThrow { NotFoundException("Autor id=$id no encontrado") }

    @Transactional
    fun create(req: AutorRequest): Autor {
        return repo.save(AutorMapper.toEntity(req))
    }

    @Transactional
    fun update(id: Long, req: AutorRequest): Autor {
        val current = get(id)
        return repo.save(AutorMapper.merge(current, req))
    }

    @Transactional
    fun delete(id: Long) {
        if (!repo.existsById(id)) throw NotFoundException("Camisa id=$id no encontrada")
        repo.deleteById(id)
    }
}
