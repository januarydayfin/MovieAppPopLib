package com.krayapp.movieapppoplib.data.imageloader

interface IImageLoader<T> {
    fun loadInto(url:String, container: T)
}