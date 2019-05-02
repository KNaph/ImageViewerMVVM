package com.tecace.retail.imageviewermvvm.ImageGrid

import android.content.Context
import android.graphics.Point
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tecace.retail.imageviewermvvm.R
import java.io.File

class ImageGridAdapter(private val context: Context, private val myImages: ArrayList<File>) :
        RecyclerView.Adapter<ImageGridAdapter.ImageViewHolder>() {

    val TAG = this.javaClass.simpleName


    class ImageViewHolder(val squareImageView: SquareImageView) : RecyclerView.ViewHolder(squareImageView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        Log.d(TAG, "KP## onCreateViewHolder")
        val squareImageView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_image_grid_image, parent, false) as SquareImageView

        return ImageViewHolder(squareImageView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
//        Log.d(TAG, "KP## The File? : ${myImages[position]}")

        val requestOptions = RequestOptions().override(getOverrideSize())

//        Log.d(TAG, "KP## request options width : ${getOverrideSize()}")

        Glide.with(context)
            .load(this.myImages[position])
            .thumbnail(0.25f)
            .apply(requestOptions)
            .into(holder.squareImageView)

        // TODO CREATE FULL SCREEN IMAGE FRAGMENT
        holder.squareImageView.setOnClickListener{
            Log.d(TAG, "KP## CLICKED ITEM : $position : ${myImages[position].name} ${getItemId(position)}")
        }
    }

    override fun getItemCount() = myImages.size

    private fun getOverrideSize() : Int {
        val display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val size = Point()

        display.getSize(size)

        return (size.x/4)

    }


}