package com.example.movieslist_mvi.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private var mcheckFields = MutableLiveData<Boolean>()
    val checkFields = mcheckFields
    private var mErrorMensage =  MutableLiveData<Any>()
    val errorMensage = mErrorMensage

    fun checkLogin(loginIntent: LoginIntent.Login){
        if (loginIntent.password.isEmpty() || loginIntent.userName.isEmpty()){
            mcheckFields.value = false
            mErrorMensage.value = LoginState.Error("Preencha todos os campos")
        } else {
            mcheckFields.value = true
        }
    }

}
sealed class LoginState(){
    data class Error(val msgError: String): LoginState()
}
sealed class LoginIntent(){
    data class Login(val userName: String, val password: String): LoginIntent()
}