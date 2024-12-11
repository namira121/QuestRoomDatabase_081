package com.example.praktikum10

import android.app.Application
import com.example.praktikum10.dependenciesinjection.ContainerApp

class KrsApp:Application() {
    //Fungsinya untuk menyimpan instance ContainerApp
    lateinit var ContainerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        //Membuat instance ContainerApp
        ContainerApp = ContainerApp(this)
        //instance adalah object yang dibuat dari class
    }
}