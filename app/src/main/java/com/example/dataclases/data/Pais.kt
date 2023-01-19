package com.example.dataclases.data

data class Pais(var nombre: String, var poblacion: Int, var capital: String) {
    override fun toString(): String {
        return "nombre = $nombre, poblacion = $poblacion, capital = $capital"
    }
}
