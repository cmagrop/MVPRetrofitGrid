package com.example.mvpretrofitgrid.presenter

import com.example.mvpretrofitgrid.model.PicsResponse
import com.example.mvpretrofitgrid.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PicturesPresenter(private val callback: PicturesView) {

    fun getPictures()
    {

        callback.showProgress()
        val api = RetrofitInstance.api.getPictures()
        api.enqueue(object : Callback<PicsResponse?> {
            override fun onResponse(
                call: Call<PicsResponse?>?,
                response: Response<PicsResponse?>?
            )  {
                callback.hideProgress()
                response?.body()?.let {
                    picsResponse -> callback.onLoadedPictures(picsResponse)
                }?:run {
                    callback.onError("Algo está mal, sin respuesta")
                }
            }

            override fun onFailure(call: Call<PicsResponse?>?, t: Throwable?) {
                callback.hideProgress()
                callback.onError(t?.message?:"Algo está mal")
            }


        })


    }



}

interface PicturesView{

    fun showProgress();

    fun hideProgress();

    fun onLoadedPictures(pics:PicsResponse)

    fun onError(error: String)

}