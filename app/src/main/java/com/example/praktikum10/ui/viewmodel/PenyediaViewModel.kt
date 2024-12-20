package com.example.praktikum10.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.praktikum10.KrsApp

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            MahasiswaViewModel(
                krsApp().ContainerApp.repositoryMhs
            )
        }

        initializer {
            HomeMhsViewModel(
                krsApp().ContainerApp.repositoryMhs
            )
        }

        initializer {
            DetailMhsViewModel(
                createSavedStateHandle(),
                krsApp().ContainerApp.repositoryMhs,
            )
        }
        initializer {
            UpdateMhsViewModel(
                createSavedStateHandle(),
                krsApp().ContainerApp.repositoryMhs,
            )
        }
    }
}

fun CreationExtras.krsApp(): KrsApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KrsApp)

