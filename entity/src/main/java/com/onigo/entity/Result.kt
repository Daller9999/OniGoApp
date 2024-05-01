package com.onigo.entity

data class Result<T>(
    val data: T? = null,
    val error: Error? = null
)