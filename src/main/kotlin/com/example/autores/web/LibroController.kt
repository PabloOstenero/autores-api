package com.example.autores.web

import com.example.autores.service.LibroService
import com.example.autores.web.dto.LibroRequest
import com.example.autores.web.dto.LibroResponse
import com.example.autores.web.mapper.LibroMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@CrossOrigin(origins = ["http://localhost:8100"])
@RestController
@RequestMapping("/api/libros")
class LibroController(private val service: LibroService) {

    @GetMapping
    fun list(): List<LibroResponse> =
        service.list().map(LibroMapper::toResponse)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): LibroResponse =
        LibroMapper.toResponse(service.get(id))

    @PostMapping
    fun create(@RequestBody req: LibroRequest): ResponseEntity<LibroResponse> {
        val saved = service.create(req)
        return ResponseEntity.created(URI.create("/api/libros/${saved.id}"))
            .body(LibroMapper.toResponse(saved))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody req: LibroRequest): LibroResponse =
        LibroMapper.toResponse(service.update(id, req))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}
