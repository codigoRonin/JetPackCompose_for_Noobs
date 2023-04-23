package com.example.proyecto_instagram.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto_instagram.login.domain.LoginUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isLoaded = MutableLiveData<Boolean>()
    val isLoaded: LiveData<Boolean> = _isLoaded

    fun onLoginChanged(email: String, password: String) {

        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    fun enableLogin(email: String, password: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 8

    fun onLoginSelected() {

        viewModelScope.launch {
            _isLoaded.value = true
            val result = loginUseCase(email.value!!, password.value!!)
            if (result) {
                //Navegar a la siguiente pantalla
                Log.i("Michel", "result OK")
            }
            delay(3000)
            _isLoaded.value = false
        }
    }
}
