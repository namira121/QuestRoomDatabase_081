package com.example.praktikum10.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.praktikum10.data.entity.Mahasiswa
import com.example.praktikum10.repository.RepositoryMhs
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

data class HomeUIState(
    val listMhs: List<Mahasiswa> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,

)
class HomeMhsViewModel(
    private val repositoryMhs: RepositoryMhs
):ViewModel(){
    val homeUIState: StateFlow<HomeUIState> = repositoryMhs.getAllMhs()
        .filterNotNull()
        .map {
            HomeUIState(
                listMhs
            )
        }
}