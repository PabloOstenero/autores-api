package com.example.autores.service

import com.example.autores.domain.Libro
import com.example.autores.repository.LibroRepository
import com.example.autores.repository.AutorRepository
import com.example.autores.web.dto.LibroRequest
import com.example.autores.web.mapper.LibroMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LibroService(
    private val repo: LibroRepository,
    private val autorRepo: AutorRepository
) {

    @Transactional(readOnly = true)
    fun list(): List<Libro> = repo.findAll().sortedBy { it.id }

    @Transactional(readOnly = true)
    fun get(id: Long): Libro =
        repo.findById(id).orElseThrow { NotFoundException("Libro id=$id no encontrado") }

    @Transactional
    fun create(req: LibroRequest): Libro {
        val autor = autorRepo.findById(req.autorId)
            .orElseThrow { NotFoundException("Autor id=${req.autorId} no encontrado") }

        val entity = LibroMapper.toEntity(req)
        entity.autor = autor
        return repo.save(entity)
    }

    @Transactional
    fun update(id: Long, req: LibroRequest): Libro {
        val current = get(id)
        val autor = autorRepo.findById(req.autorId)
            .orElseThrow { NotFoundException("Autor id=${req.autorId} no encontrado") }

        val merged = LibroMapper.merge(current, req)
        merged.autor = autor
        return repo.save(merged)
    }

    @Transactional
    fun delete(id: Long) {
        if (!repo.existsById(id)) throw NotFoundException("Libro id=$id no encontrada")
        repo.deleteById(id)
    }
}
