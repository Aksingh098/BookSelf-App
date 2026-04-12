package com.example.bookself

import android.app.Application
import com.example.bookself.data.AppContainer
import com.example.bookself.data.DefaultAppContainer

class BookselfApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}