package com.example.autores.repository

import com.example.autores.domain.Libro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LibroRepository : JpaRepository<Libro, Long>
