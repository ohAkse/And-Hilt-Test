package com.example.hiltpractice.repositories

import javax.inject.Inject
import javax.inject.Singleton

interface LocalRepository {
    fun getData(): String
}

@Singleton
class LocalRepositoryImpl @Inject constructor() : LocalRepository {
    override fun getData(): String {
        return "레포지토리 구현"
    }
}
