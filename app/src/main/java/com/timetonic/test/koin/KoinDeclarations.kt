package com.timetonic.test.koin

import com.timetonic.test.dataAccess.SharedPreferencesProvider
import com.timetonic.test.network.NetworkProvider
import org.koin.dsl.module

object KoinDeclarations {

    fun getSharedPreferencesModule() = module {
        single { SharedPreferencesProvider(get()).getSharedPreferences() }
    }

    fun getNetworkModule() = module {
        single { NetworkProvider().provideNetwork() }
    }
}
