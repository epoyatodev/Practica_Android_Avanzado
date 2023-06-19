package com.poyatodev.practica_android_avanzado


fun generateFakeToken():String{
    var fakeToken = ""
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    var has254Chars = false
    while (!has254Chars){
        fakeToken = "f$fakeToken${allowedChars.random()}"
        if(fakeToken.length >= 253){
            has254Chars = true
        }
    }
    return fakeToken
}


