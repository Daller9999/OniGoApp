package com.onigo.repository

import com.onigo.api.moduleApi
import org.koin.dsl.module

val moduleRepository = module {
    factory { OniGoRepository(get()) }
}

val repositoryCoreDi = moduleRepository + moduleApi