package com.example.hiltpractice.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hiltpractice.repositories.LocalRepository
import com.example.hiltpractice.services.FileService
import com.example.hiltpractice.services.NetworkService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppActivityViewModel @Inject constructor(
    private val repository: LocalRepository,
    private val networkService: NetworkService,
    private val fileService: FileService
) : ViewModel() {

    private val _repositoryData = MutableLiveData<String>()
    val repositoryData: LiveData<String> = _repositoryData

    private val _networkData = MutableLiveData<String>()
    val networkData: LiveData<String> = _networkData

    private val _fileData = MutableLiveData<String>()
    val fileData: LiveData<String> = _fileData

    fun fetchData() {
        _repositoryData.value = repository.getData()
        _networkData.value = networkService.getData()
        _fileData.value = fileService.getData()
    }
}