package com.other.dagger.storage

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String): String
}
