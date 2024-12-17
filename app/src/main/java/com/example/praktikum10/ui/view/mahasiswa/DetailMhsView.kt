package com.example.praktikum10.ui.view.mahasiswa

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Delete
import com.example.praktikum10.ui.customwidget.TopAppBar
import com.example.praktikum10.ui.viewmodel.DetailMhsViewModel
import com.example.praktikum10.ui.viewmodel.DetailUIState
import com.example.praktikum10.ui.viewmodel.PenyediaViewModel

@Composable
fun DetailMhsView(
    modifier: Modifier = Modifier,
    viewModel: DetailMhsViewModel = viewModel(factory = PenyediaViewModel.Factory),
    onBack: () -> Unit = { },
    onEditClick: (String) -> Unit = { },
    onDeleteClick: () -> Unit = { }
) {
    Scaffold (
        topBar = {
            TopAppBar(
                judul = "Detail Mahasiswa",
                showBackButton = true,
                onBack = onBack,
                modifier = modifier
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEditClick(viewModel.detailUIState.value.detailUiEvent.nim) },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Mahasiswa",
                    )
            }
        }
    ){innerPadding ->
        val detailUIState by viewModel.detailUIState.collectAsState()

        BodyDetailMhs(
            modifier = Modifier.padding(innerPadding),
            detailUIState = detailUIState,
            onDeleteClick = {
                viewModel.deleteMhs()
                onDeleteClick()
            }
        )
    }
}

@Composable
fun BodyDetailMhs(
    modifier: Modifier = Modifier,
    detailUIState: DetailUIState = DetailUIState(),
    onDeleteClick: () -> Unit = { }
){

}
