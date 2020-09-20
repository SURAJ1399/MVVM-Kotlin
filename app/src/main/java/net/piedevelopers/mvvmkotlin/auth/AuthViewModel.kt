package net.piedevelopers.mvvmkotlin.auth

import android.view.View
import androidx.lifecycle.ViewModel
import net.piedevelopers.mvvmkotlin.repo.UserRepo

class AuthViewModel:ViewModel() {
    var email :String?=null;
    var password:String?=null
    var authListner:AuthListner?=null
    var isenabled: Boolean =true


    fun onLoginButtonClicked(view: View)
    {
        isenabled=false
        authListner?.OnStarted()
        if(email.isNullOrEmpty()|| password.isNullOrEmpty())
        {
            authListner?.OnFailure("Invalid Email Id Or Password")
            isenabled=true
            return
        }
        //this is bad practice because we are making AuthViewModel Class Dependent on UserRepo class
        // (in short we are creating a instance of UserRepo class here).Therefore we use  dependency injection.

        val loginresponse=UserRepo().userLogin(email!!,password!!)

        authListner?.OnSucess(loginresponse)
        isenabled=true
    }

}