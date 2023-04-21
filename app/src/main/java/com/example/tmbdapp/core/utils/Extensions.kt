package com.example.tmbdapp.core.utils

import okhttp3.Request

fun Request.addTMDBKeys(): Request{
    val builder = this.newBuilder()//TODO FINISH THIS
    return builder.build()
}

fun String.enumToName() : String{
    var res : String = this[0].toString()
    for (i in  1 until this.length){
        if(this[i] == '_'){
            res+=" "
        }
        else{
            res+= this[i].lowercase()
        }
    }
    return res
}