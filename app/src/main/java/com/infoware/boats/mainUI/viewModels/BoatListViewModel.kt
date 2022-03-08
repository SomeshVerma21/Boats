package com.infoware.boats.mainUI.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infoware.boats.Utils.RetrofitApiService
import com.infoware.boats.mainUI.models.BoatsModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class BoatListViewModel : ViewModel(){
    var _listBoats = MutableLiveData<BoatsModel>()

    val listBoats:LiveData<BoatsModel>
        get() = _listBoats

    init {
        getBoatsList()
    }

    private fun getBoatsList()
    {
        viewModelScope.launch {
            val call = RetrofitApiService.retrofitService.getCruiseList()
            call.enqueue(object :Callback<BoatsModel>{
                override fun onResponse(call: Call<BoatsModel>, response: Response<BoatsModel>) {
                    Log.d("ViewModel", response.body()?.data?.size.toString())
                    _listBoats.value = response.body()
                    Log.d("ViewModel", response.message())
                }

                override fun onFailure(call: Call<BoatsModel>, t: Throwable) {
                    Log.d("ViewModel", "Failer ${t.message}")
                }
            })
        }
    }
}