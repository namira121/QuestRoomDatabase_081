package com.example.praktikum10.repository

import com.example.praktikum10.data.dao.MahasiswaDao
import com.example.praktikum10.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

class LocalRepositoryMhs(
    private val mahasiswaDao: MahasiswaDao
) : RepositoryMhs {
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }

    fun getAllMhs(): Flow<List<Mahasiswa>>
}