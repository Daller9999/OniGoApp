package com.onigo.api

import com.onigo.entity.Error
import com.onigo.entity.Result
import com.onigo.entity.numbercheck.NumberCheck
import kotlinx.coroutines.delay

class OniGoApi {

    suspend fun requestNumber(number: String): Result<NumberCheck> {
        delay(1000)
        return if (number.toInt() % 2 == 1) {
            Result(data = NumberCheck(111))
        } else {
            Result(error = Error(111, "error"))
        }
    }

}