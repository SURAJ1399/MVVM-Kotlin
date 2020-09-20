package net.piedevelopers.mvvmkotlin.auth

interface AuthListner {
    fun OnStarted()
    fun OnSucess()
    fun OnFailure(message:String)

}