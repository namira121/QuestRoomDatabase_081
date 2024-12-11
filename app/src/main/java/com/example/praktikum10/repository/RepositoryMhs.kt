package com.example.praktikum10.repository

import com.example.praktikum10.data.entity.Mahasiswa

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
}