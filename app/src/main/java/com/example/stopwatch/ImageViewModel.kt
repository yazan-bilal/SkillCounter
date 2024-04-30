package com.example.stopwatch

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ImageViewModel:ViewModel() {


    var uri:Uri? = null
        private set

    fun updateUri(uri: Uri?){
        this.uri = uri
    }
}