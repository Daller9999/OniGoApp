package com.onigo.repository

import com.onigo.api.OniGoApi

class OniGoRepository(
    private val oniGoApi: OniGoApi
) {

    // made this in case if need to fix some api calls, etc
    suspend fun requestNumber(number: String) = oniGoApi.requestNumber(number)


}