package com.example.tmbdapp.core.utils

import okhttp3.Request

fun Request.addTMDBKeys(): Request{
    val builder = this.newBuilder()//TODO FINISH THIS
    return builder.build()
}