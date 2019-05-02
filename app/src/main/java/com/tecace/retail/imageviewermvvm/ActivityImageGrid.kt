package com.tecace.retail.imageviewermvvm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tecace.retail.imageviewermvvm.ImageGrid.FragmentImageGrid

class ActivityImageGrid : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagegrid)

        setupGridFragment()

    }

    private fun setupGridFragment() {
        val imageGridFragment = FragmentImageGrid()
        supportFragmentManager.beginTransaction().replace(R.id.content_frame, imageGridFragment).commit()
    }
}
