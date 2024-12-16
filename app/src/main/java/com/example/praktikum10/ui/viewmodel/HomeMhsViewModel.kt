package com.example.praktikum10.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.praktikum10.repository.RepositoryMhs
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull

class HomeMhsViewModel(
    private val repositoryMhs: RepositoryMhs
):ViewModel(){
    val homeUIState: StateFlow<HomeUIState> = repositoryMhs.getAllMhs()
        .filterNotNull()
}