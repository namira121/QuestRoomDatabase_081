package com.example.praktikum10.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum10.repository.RepositoryMhs
import com.example.praktikum10.ui.navigation.DestinasiUpdate
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UpdateMhsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: RepositoryMhs
): ViewModel(){
    var updateUIState by mutableStateOf(MhsUIState())
        private set

    private val _nim: String = checkNotNull(savedStateHandle[DestinasiUpdate.NIM])

    init {
        viewModelScope.launch {
            updateUIState=repositoryMhs.getMhs(_nim)
                .filterNotNull()
                .first()
                .toUIStateMhs()
        }
    }

    fun UpdateState(mahasiswaEvent: MahasiswaEvent){
        updateUIState = updateUIState.copy(
            mahasiswaEvent = mahasiswaEvent,
        )
    }

    fun ValidateFields(): Boolean{
        val event = updateUIState.mahasiswaEvent
        val errorState = FormErrorState(
            nim = if (event.nim.isNotEmpty()) null else "NIM tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            jenisKelamin = if (event.jenisKelamin.isNotEmpty()) null else "Jenis Kelamin tidak boleh kosong",
            alamat = if (event.alamat.isNotEmpty()) null else "Alamat Kelamin tidak boleh kosong",
            kelas = if (event.kelas.isNotEmpty()) null else "Kelas Kelamin tidak boleh kosong",
        )
    }
}