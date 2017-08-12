package com.kodesmell.kodesmell

import android.app.Application
import com.apollographql.apollo.ApolloClient
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.autoAndroidModule
import com.kodesmell.kodesmell.api.ApiManager

/**
 * Created by sangcomz on 12/08/2017.
 */
class KodeApplication : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        import(autoAndroidModule(this@KodeApplication))
        bind<ApolloClient>() with singleton { ApiManager().getClient() }
    }
}