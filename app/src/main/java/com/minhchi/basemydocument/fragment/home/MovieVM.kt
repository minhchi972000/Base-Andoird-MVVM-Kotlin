package com.example.firebasekotlin.fragment.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.minhchi.basemydocument.model.RepositoryData
import com.minhchi.basemydocument.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MovieVM @Inject constructor(private val repository: RetroRepository): ViewModel() {

    fun getAllRepositoryList(): LiveData<List<RepositoryData>> {
        return repository.getAllRecords()
    }

    fun makeApiCall() {
        repository.makeApiCall("ny")
    }

}
