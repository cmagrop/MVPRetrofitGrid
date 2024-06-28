package com.example.mvpretrofitgrid.view

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
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

        binding.progress.visibility = View.VISIBLE


    }

    override fun hideProgress() {
        binding.progress.visibility = View.GONE
    }

    override fun onLoadedPictures(pics: PicsResponse) {

        val adapter = PicsAdapter(this)
        adapter.setList(pics)

        binding.rvPics.setHasFixedSize(true)
        binding.rvPics.layoutManager = GridLayoutManager(this,2)
        binding.rvPics.adapter = adapter


    }

    override fun onError(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show()
    }
}
