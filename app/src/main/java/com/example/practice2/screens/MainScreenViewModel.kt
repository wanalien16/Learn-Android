package com.example.practice2.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice2.data.Developers
import com.example.practice2.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel(){
    private val _state = MutableStateFlow<List<Developers>>(emptyList())
    val state: StateFlow<List<Developers>> get() = _state

    init {
        getDevelopers()
    }

    private fun getDevelopers(){
        viewModelScope.launch(Dispatchers.IO){

            try {
                val response = RetrofitInstance.api.getDevelopers("en")

                Log.i("getting", "getting data $response")

                  _state.value = response



            }
            catch (e: Exception){
                e.printStackTrace()
            }



        }

    }






}