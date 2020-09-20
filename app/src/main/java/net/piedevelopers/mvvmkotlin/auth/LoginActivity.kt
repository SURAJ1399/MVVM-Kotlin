package net.piedevelopers.mvvmkotlin.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_login.*
import net.piedevelopers.mvvmkotlin.R
import net.piedevelopers.mvvmkotlin.databinding.ActivityLoginBinding
import net.piedevelopers.mvvmkotlin.util.hide
import net.piedevelopers.mvvmkotlin.util.show
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
     progress_bar.show()
        toast("Login Started")


    }

    override fun OnSucess(loginresponse: LiveData<String>) {

      loginresponse.observe(this, Observer {
          progress_bar.hide()
          toast(it)
      })
    }

    override fun OnFailure(message: String) {
        progress_bar.hide()
        toast(message)

    }
}
