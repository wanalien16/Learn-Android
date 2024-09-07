package com.example.practice2.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice2.data.Developers
import com.example.practice2.data.Repositories
import com.example.practice2.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel(){
    private val _developerstate = MutableStateFlow<List<Developers>>(emptyList())
    val developerstate: StateFlow<List<Developers>> get() = _developerstate

    private val _repositoriesState = MutableStateFlow<List<Repositories>>(emptyList())
    val repositoriesstate: StateFlow<List<Repositories>> get() = _repositoriesState



    init {
        getDevelopers()
    }

    private fun getDevelopers(){
        viewModelScope.launch(Dispatchers.IO){

            try {
                val responseofDevelopers = RetrofitInstance.api.getDevelopers("en")

                Log.i("getting", "getting data $responseofDevelopers")

                  _developerstate.value = responseofDevelopers

                val responseofRepositories = RetrofitInstance.api.getRepositories("en")

                _repositoriesState.value = responseofRepositories





            }
            catch (e: Exception){
                e.printStackTrace()
            }



        }

    }






}