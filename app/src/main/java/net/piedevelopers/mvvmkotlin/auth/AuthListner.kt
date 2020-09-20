package net.piedevelopers.mvvmkotlin.auth

import androidx.lifecycle.LiveData

interface AuthListner {
    fun OnStarted()
    fun OnSucess(loginresponse: LiveData<String>)
    fun OnFailure(message:String)

}