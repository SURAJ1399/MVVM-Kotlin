package net.piedevelopers.mvvmkotlin.auth

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import java.util.*

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
        authListner?.OnSucess()
        isenabled=true
    }

}