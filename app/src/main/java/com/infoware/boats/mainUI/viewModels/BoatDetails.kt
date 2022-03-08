package com.infoware.boats.mainUI.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infoware.boats.Utils.RetrofitApiService
import com.infoware.boats.mainUI.models.boatDetailsModel.BoatDetailsModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class BoatDetails(): ViewModel()
{
    val _response = MutableLiveData<Boolean>()
    val resultData = MutableLiveData<BoatDetailsModel>()

    fun getDetailsOfBoat(id:String){
        viewModelScope.launch {
            val call = RetrofitApiService.retrofitService.getCruiseDetails(id)
            call.enqueue(object : Callback, retrofit2.Callback<BoatDetailsModel> {
                override fun onResponse(call: Call<BoatDetailsModel>, response: Response<BoatDetailsModel>) {
                    if (response.isSuccessful){
                        _response.value = true
                        resultData.value = response.body()
                        Log.d("ViewModel", response.body()?.data?.cruise_name+"")
                    }
                }

                override fun onFailure(call: Call<BoatDetailsModel>, t: Throwable) {
                    _response.value = false
                    Log.d("ViewModel", t.message.toString())
                }
            })
        }
    }
}