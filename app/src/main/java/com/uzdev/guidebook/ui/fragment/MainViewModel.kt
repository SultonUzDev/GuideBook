package com.uzdev.alichtechtask.ui.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uzdev.guidebook.api.ApiService
import com.uzdev.alichtechtask.api.RetrofitInstance
import com.uzdev.guidebook.model.GuideData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    lateinit var guideListData: MutableLiveData<GuideData>

    init {
        guideListData = MutableLiveData()
    }

    fun getGuideDataObserve(): MutableLiveData<GuideData> {
        return guideListData
    }

    fun makeApiCall() {

        val retrofitInstance = RetrofitInstance.getInstance().create(ApiService::class.java)
        val call = retrofitInstance.getData()
        call.enqueue(object : Callback<GuideData> {
            override fun onResponse(call: Call<GuideData>, response: Response<GuideData>) {
                if (response.isSuccessful && response.body() != null) {
                    guideListData.postValue(response.body())
                } else {
                    guideListData.postValue(null)
                }
            }

            override fun onFailure(call: Call<GuideData>, t: Throwable) {
                guideListData.postValue(null)
            }
        })
    }

}
