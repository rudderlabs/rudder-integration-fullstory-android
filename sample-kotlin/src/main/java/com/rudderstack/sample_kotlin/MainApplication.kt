package com.rudderstack.sample_kotlin

import android.app.Application
import com.rudderstack.android.integrations.fullstory.FullStoryIntegrationFactory
import com.rudderstack.android.sdk.core.RudderClient
import com.rudderstack.android.sdk.core.RudderConfig
import com.rudderstack.android.sdk.core.RudderLogger

class MainApplication : Application() {
    companion object {
        private const val WRITE_KEY = "1xwMDX5BwehYuZv0BuXOezWmgHt"
        private const val DATA_PLANE_URL = "https://ed19-2405-201-8000-6102-7155-d956-c1f9-9985.ngrok.io"
        private const val CONTROL_PLANE_URL = "https://c3ef-2405-201-8000-6102-7155-d956-c1f9-9985.ngrok.io"
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