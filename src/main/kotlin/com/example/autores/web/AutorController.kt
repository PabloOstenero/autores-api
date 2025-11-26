package com.example.autores.web

import com.example.autores.service.AutorService
import com.example.autores.web.dto.AutorRequest
import com.example.autores.web.dto.AutorResponse
import com.example.autores.web.mapper.AutorMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@CrossOrigin(origins = ["http://localhost:8100"])
@RestController
@RequestMapping("/api/autores")
class AutorController(private val service: AutorService) {

    @GetMapping
    fun list(): List<AutorResponse> =
        service.list().map(AutorMapper::toResponse)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): AutorResponse =
        AutorMapper.toResponse(service.get(id))

    @PostMapping
    fun create(@RequestBody req: AutorRequest): ResponseEntity<AutorResponse> {
        val saved = service.create(req)
        return ResponseEntity.created(URI.create("/api/autores/${saved.id}"))
            .body(AutorMapper.toResponse(saved))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody req: AutorRequest): AutorResponse =
        AutorMapper.toResponse(service.update(id, req))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}
