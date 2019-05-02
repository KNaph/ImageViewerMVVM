package com.tecace.retail.imageviewermvvm.data.source

class ImageRepository(val imageLocalDataSource: ImageDataSource) :
    ImageDataSource {
    override fun getImages(callback: ImageDataSource.LoadImagesCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getImage(imagePath: String, callback: ImageDataSource.GetImagesCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}