package com.timetonic.test.koin

import com.timetonic.test.dataAccess.SharedPreferencesProvider
import com.timetonic.test.login.data.LoginRepository
import com.timetonic.test.login.data.LoginRepositoryImpl
import com.timetonic.test.login.data.remote.LoginService
import com.timetonic.test.login.data.remote.LoginServiceImpl
import com.timetonic.test.network.NetworkProvider
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object KoinDeclarations {

    fun getSharedPreferencesModule() = module {
        single { SharedPreferencesProvider(get()).getSharedPreferences() }
    }

    fun getNetworkModule() = module {
        single { NetworkProvider().provideNetwork() }
    }

    fun getLoginModule() = module {
        single { NetworkProvider().provideLoginApi(get()) }
        singleOf(::LoginServiceImpl) { bind<LoginService>() }
        singleOf(::LoginRepositoryImpl) { bind<LoginRepository>() }
    }
}
