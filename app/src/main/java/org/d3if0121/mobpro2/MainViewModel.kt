package org.d3if0121.mobpro2

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                requestData()
            }
        }
    }
    private suspend fun requestData() {
        try {
            val result = Covid19Api.service.getData()
            Log.d("REQUEST", "Data size: ${result.update.harian.size}")
        }
        catch (e: Exception) {
            Log.d("REQUEST", e.message.toString())
        }
    }
}
