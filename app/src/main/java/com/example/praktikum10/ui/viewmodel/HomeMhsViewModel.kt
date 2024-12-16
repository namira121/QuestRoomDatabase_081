package com.example.praktikum10.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.praktikum10.data.entity.Mahasiswa
import com.example.praktikum10.repository.RepositoryMhs
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

data class HomeUIState(
    val listMhs: List<Mahasiswa> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)
class HomeMhsViewModel(
    private val repositoryMhs: RepositoryMhs
):ViewModel(){
    val homeUIState: StateFlow<HomeUIState> = repositoryMhs.getAllMhs()
        .filterNotNull()
        .map {
            HomeUIState(
                listMhs = it.toList(),
                isLoading = false,
            )
        }
        .onStart {
            emit(HomeUIState(isLoading = true))
            delay(900)
        }


}