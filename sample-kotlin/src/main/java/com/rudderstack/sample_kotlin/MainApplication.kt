package com.rudderstack.sample_kotlin

import android.app.Application
import com.rudderstack.android.integrations.fullstory.FullStoryIntegrationFactory
import com.rudderstack.android.sdk.core.RudderClient
import com.rudderstack.android.sdk.core.RudderConfig
import com.rudderstack.android.sdk.core.RudderLogger

class MainApplication : Application() {
    companion object {
        private const val WRITE_KEY = "20mOicfIDNbvijUXHEhrxOsEjZt"
        private const val DATA_PLANE_URL = "https://51e7-2405-201-8000-60e4-6496-b71d-bec7-6305.ngrok.io"
        private const val CONTROL_PLANE_URL = "https://b5c2-2405-201-8000-60e4-6496-b71d-bec7-6305.ngrok.io"

//        private const val WRITE_KEY = "20mK7LsFTSsvxOLRJLqgNyWdr7S"
//        private const val DATA_PLANE_URL = "https://hosted-dev-dataplane.dev-rudder.rudderlabs.com"
//        private const val CONTROL_PLANE_URL = "https://api.dev.rudderlabs.com"


        lateinit var rudderClient: RudderClient
    }

    override fun onCreate() {
        super.onCreate()
        rudderClient = RudderClient.getInstance(
            this,
            WRITE_KEY,
            RudderConfig.Builder()
                .withDataPlaneUrl(DATA_PLANE_URL)
                .withControlPlaneUrl(CONTROL_PLANE_URL)
                .withFactory(FullStoryIntegrationFactory.FACTORY)
                .withLogLevel(RudderLogger.RudderLogLevel.VERBOSE)
                .withTrackLifecycleEvents(false)
                .build()
        )
    }
}