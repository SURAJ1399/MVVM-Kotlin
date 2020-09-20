package net.piedevelopers.mvvmkotlin.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.piedevelopers.mvvmkotlin.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo {
    fun userLogin(email:String,password:String):LiveData<String> {


        val loginResponse = MutableLiveData<String>()


          //this is bad practice because we are making UserRepo Class Dependent on MyApi
        // (in short we are creating a instance of MyApi class here).Therefore we use  dependency injection.
        MyApi().userLogin(email,password).enqueue(object :Callback<ResponseBody>{

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
              loginResponse.value=t.message
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
              if(response.isSuccessful)
              {
                  loginResponse.value=response.body()?.string()
              }
                else
              {
                  loginResponse.value=response.errorBody()?.string()

              }
            }

        })
        return  loginResponse;

    }

    }