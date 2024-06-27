package com.example.mvpretrofitgrid.presenter

import com.example.mvpretrofitgrid.model.PicsResponse

class PicturesPresenter(private val callback: PicturesView) {

    fun getPictures()
    {

        callback.showProgress()


    }



}

interface PicturesView{

    fun showProgress();

    fun hideProgress();

    fun onLoadedPictures(pics:PicsResponse)

    fun onError(error: String)

}