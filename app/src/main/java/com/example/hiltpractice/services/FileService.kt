package com.example.hiltpractice.services

import javax.inject.Inject

interface FileService {
    fun getData(): String
}

class FileServiceImpl @Inject constructor() : FileService {
    override fun getData(): String {
        return "파일 구현"
    }
}
