package com.example.proyecto_instagram.login.domain

import com.example.proyecto_instagram.login.data.LoginRepository

class LoginUseCase {

    private val repository = LoginRepository()

    suspend operator fun invoke(user:String, password: String):Boolean{
        return repository.doLogin(user, password)
    }
}