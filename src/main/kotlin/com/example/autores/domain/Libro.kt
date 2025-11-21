package com.example.autores.domain

import jakarta.persistence.*

@Entity
@Table(name = "libros")
data class Libro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var titulo: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    var autor: Autor? = null
)