package com.example.praktikum10.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.praktikum10.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow


@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(
        mahasiswa: Mahasiswa //yang dipanggil tabelnya
    )

    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa(): Flow<List<Mahasiswa>>
}