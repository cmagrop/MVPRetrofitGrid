package com.example.mvpretrofitgrid.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mvpretrofitgrid.R
import com.example.mvpretrofitgrid.databinding.ActivityMainBinding
import com.example.mvpretrofitgrid.model.PicsResponse
import com.example.mvpretrofitgrid.presenter.PicturesPresenter
import com.example.mvpretrofitgrid.presenter.PicturesView
import com.example.mvpretrofitgrid.view.adapter.PicsAdapter

//class MainActivity extends AppCompatActivity implements PicturesView
class MainActivity : AppCompatActivity(),PicturesView {
    //binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init()
    {
        val presenter = PicturesPresenter(this)
        presenter.getPictures()
    }

    override fun showProgress() {



    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun onLoadedPictures(pics: PicsResponse) {



    }

    override fun onError(error: String) {
        TODO("Not yet implemented")
    }
}