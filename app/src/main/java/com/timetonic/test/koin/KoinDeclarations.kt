package com.timetonic.test.koin

import com.timetonic.test.dataAccess.sharedPreferences.manager.SharedPreferencesManager
import com.timetonic.test.dataAccess.sharedPreferences.manager.SharedPreferencesManagerImpl
import com.timetonic.test.dataAccess.sharedPreferences.provider.SharedPreferencesProvider
import com.timetonic.test.login.LoginViewModel
import com.timetonic.test.login.data.LoginRepository
import com.timetonic.test.login.data.LoginRepositoryImpl
import com.timetonic.test.login.data.remote.LoginService
import com.timetonic.test.login.data.remote.LoginServiceImpl
import com.timetonic.test.network.NetworkProvider
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object KoinDeclarations {

    fun getSharedPreferencesModule() = module {
        single { SharedPreferencesProvider(get()).getSharedPreferences() }
        singleOf(::SharedPreferencesManagerImpl) { bind<SharedPreferencesManager>() }
    }

    fun getNetworkModule() = module {
        single { NetworkProvider().provideNetwork() }
    }

    fun getLoginModule() = module {
        single { NetworkProvider().provideLoginApi(get()) }
        singleOf(::LoginServiceImpl) { bind<LoginService>() }
        singleOf(::LoginRepositoryImpl) { bind<LoginRepository>() }
        viewModelOf(::LoginViewModel)
    }
}
