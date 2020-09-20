package net.piedevelopers.mvvmkotlin.auth

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProviders
import net.piedevelopers.mvvmkotlin.R
import net.piedevelopers.mvvmkotlin.databinding.ActivityLoginBinding
import net.piedevelopers.mvvmkotlin.util.toast

class LoginActivity : AppCompatActivity(),
    AuthListner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       val binding: ActivityLoginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login)

         val viewModel= ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel=viewModel

        viewModel.authListner=this
    }

    override fun OnStarted() {
        toast("Login Started")


    }

    override fun OnSucess() {
        toast("Login Success")
    }

    override fun OnFailure(message: String) {
        toast(message)

    }
}
