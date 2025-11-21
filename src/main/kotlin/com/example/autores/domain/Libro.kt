package com.example.autores.domain

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators

@Entity
@Table(name = "libros")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
data class Libro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var titulo: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    var autor: Autor? = null
)
