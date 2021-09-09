package com.rudderstack.android.sample.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rudderlabs.android.sample.kotlin.R
import com.rudderstack.android.sdk.core.RudderProperty
import com.rudderstack.android.sdk.core.RudderTraits

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainApplication.rudderClient.identify(
            RudderTraits()
                .put("name2","RandomName")
                .putName("Rudderstack")
                .putAge("12")
                .putEmail("support@rudderstack.com")
        )

        MainApplication.rudderClient.group("GroupID",
            RudderTraits()
                .putEmail("support@rudderstack.com")
        )

        MainApplication.rudderClient.screen("Screen Call",
            RudderProperty()
                .putValue("name2", "RandomName")
                .putValue("Age", "12")
                .putValue("Email", "support@rudderstack.com")
        )

        MainApplication.rudderClient.track("Track Call",
            RudderProperty()
                .putValue("name2", "RandomName")
                .putValue("Age", "12")
                .putValue("Email", "support@rudderstack.com")
        )

        MainApplication.rudderClient.reset()
    }
}
