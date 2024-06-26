package com.onigo.api

import com.onigo.entity.Error
import com.onigo.entity.Result
import com.onigo.entity.numbercheck.NumberCheck
import kotlinx.coroutines.delay

class OniGoApi {

    suspend fun requestNumber(number: String): Result<NumberCheck> {
        // api request emulation
        delay(1000)
        // emulation of different result from api
        return if (number.toLong() % 2 == 0L) {
            Result(data = NumberCheck(111))
        } else {
            Result(error = Error(111, "error"))
        }
    }

}