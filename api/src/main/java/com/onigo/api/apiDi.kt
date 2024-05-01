package com.onigo.api

import org.koin.dsl.module

val moduleApi = module {
    factory { OniGoApi() }
}