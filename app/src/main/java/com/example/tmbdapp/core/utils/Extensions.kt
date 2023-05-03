package com.example.tmbdapp.core.utils

import okhttp3.Request

fun Request.addTMDBKeys(): Request{
    val builder = this.newBuilder()
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

fun Int.idToGenre() : String {
    if(this == 28) return "Action"
    if(this == 12) return "Adventure"
    if(this == 16) return "Animation"
    if(this == 35) return "Comedy"
    if(this == 80) return "Crime"
    if(this == 99) return "Documentary"
    if(this == 18) return "Drama"
    if(this == 19751) return "Family"
    if(this == 14) return "Fantasy"
    if(this == 36) return "History"
    if(this == 27) return "Horror"
    if(this == 10402) return "Music"
    if(this == 9648) return "Mystery"
    if(this == 10749) return "Romance"
    if(this == 878) return "Science Fiction"
    if(this == 10770) return "TV Movie"
    if(this == 53) return "Thriller"
    if(this == 10752) return "War"
    if(this == 37) return "Western"
    return ""
}

fun String.toYear() : String{
    return this.split('-')[0]
}