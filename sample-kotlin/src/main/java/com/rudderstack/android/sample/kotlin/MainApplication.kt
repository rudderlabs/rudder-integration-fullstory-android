package com.rudderstack.android.sample.kotlin

import android.app.Application
import com.rudderstack.android.integrations.fullstory.FullStoryIntegrationFactory
import com.rudderstack.android.sdk.core.RudderClient
import com.rudderstack.android.sdk.core.RudderConfig
import com.rudderstack.android.sdk.core.RudderLogger

class MainApplication : Application() {
    companion object {
        private const val WRITE_KEY = "1xIr1sV5n7yTlpYO3IxrWIvK9Q6"
        private const val DATA_PLANE_URL = "https://941a-2405-201-8000-609d-6467-f5-fcc5-20f.ngrok.io"
        private const val CONTROL_PLANE_URL = "https://5416-2405-201-8000-609d-6467-f5-fcc5-20f.ngrok.io"
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
                .build()
        )
    }
}