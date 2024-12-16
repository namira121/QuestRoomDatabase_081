package com.example.praktikum10.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum10.repository.RepositoryMhs
import com.example.praktikum10.ui.navigation.DestinasiDetail
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailMhsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: RepositoryMhs,
):ViewModel(){
    private val _nim: String = checkNotNull(savedStateHandle[DestinasiDetail.NIM])

    val detailUIState: StateFlow<DetailUIState> = repositoryMhs.getMhs(_nim)
        .filterNotNull()
        .map {
            DetailUIState(
                detailUIState = it.toDetailUiEvent(),
                isLoading = false,
            )
        }
        .catch {
            emit(
                DetailUIState(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?:"Terjadi kesalahan",
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(2000),
            initialValue = DatailUIState(
                isLoading = true,
            )
        )
}