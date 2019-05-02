package com.tecace.retail.imageviewermvvm.data.source

import java.io.File

interface ImageDataSource {
    interface LoadImagesCallback {
        fun onImagesLoaded(images: List<File>)

        fun onDataNotAvailable()
    }

    interface GetImagesCallback {
        fun onImagesLoaded(image: File)

        fun onDataNotAvailable()
    }

    fun getImages(callback: LoadImagesCallback)

    fun getImage(imagePath: String, callback: GetImagesCallback)

    fun putImages()
}