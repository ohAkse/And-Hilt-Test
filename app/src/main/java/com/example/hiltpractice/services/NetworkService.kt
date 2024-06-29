package com.example.hiltpractice.services

import javax.inject.Inject

interface NetworkService {
    fun getData(): String
}

class NetworkServiceImpl @Inject constructor() : NetworkService {
    override fun getData(): String {
        return "네트워크 구현"
    }
}
