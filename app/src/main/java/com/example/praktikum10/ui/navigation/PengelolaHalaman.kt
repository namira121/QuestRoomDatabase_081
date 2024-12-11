package com.example.praktikum10.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum10.ui.view.mahasiswa.DestinasiInsert
import com.example.praktikum10.ui.view.mahasiswa.InsertMhsView
import java.nio.file.WatchEvent


@Composable
fun PengelolaHalaman(
    navHostController: NavHostController= rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navHostController,
        startDestination = DestinasiInsert.route) {
        composable(
            route = DestinasiInsert.route
        ) {
            InsertMhsView(
                onBack = {}, onNavigate = { })
        }
    }
}

