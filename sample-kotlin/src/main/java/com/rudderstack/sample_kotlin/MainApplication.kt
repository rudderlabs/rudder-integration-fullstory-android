package com.rudderstack.sample_kotlin

import android.app.Application
import com.fullstory.FS
import com.fullstory.FSOnReadyListener
import com.fullstory.FSSessionData
import com.rudderstack.android.integrations.fullstory.FullStoryIntegrationFactory
import com.rudderstack.android.sdk.core.RudderClient
import com.rudderstack.android.sdk.core.RudderConfig
import com.rudderstack.android.sdk.core.RudderLogger

class MainApplication : Application() {
    companion object {
        lateinit var rudderClient: RudderClient
    }

    override fun onCreate() {
        super.onCreate()
        rudderClient = RudderClient.getInstance(
            this,
            BuildConfig.WRITE_KEY,
            RudderConfig.Builder()
                .withDataPlaneUrl(BuildConfig.DATA_PLANE_URL)
                .withFactory(FullStoryIntegrationFactory.FACTORY)
                .withLogLevel(RudderLogger.RudderLogLevel.NONE)
                .withTrackLifecycleEvents(false)
                .build()
        )

        FS.setReadyListener(FSSessionReadyListener())
    }
    private class FSSessionReadyListener : FSOnReadyListener {
        override fun onReady(sessionData: FSSessionData) {
            val sessionUrl = sessionData.currentSessionURL
            println("FullStory Session URL is: $sessionUrl")
        }
    }
}