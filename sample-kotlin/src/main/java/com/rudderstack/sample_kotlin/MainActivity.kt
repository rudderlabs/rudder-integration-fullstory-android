package com.rudderstack.sample_kotlin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fullstory.FS
import com.rudderstack.android.sdk.core.RudderProperty
import com.rudderstack.android.sdk.core.RudderTraits
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val restart = findViewById<Button>(R.id.restart)
        restart?.setOnClickListener {
            FS.restart()
        }

        val track = findViewById<Button>(R.id.track)
        track?.setOnClickListener {
            track()
        }


        val identify = findViewById<Button>(R.id.identify)
        identify?.setOnClickListener {
            identify()
        }

        val screen = findViewById<Button>(R.id.screen)
        screen?.setOnClickListener {
            screen()
        }

        val reset = findViewById<Button>(R.id.rst)
        reset?.setOnClickListener() {
            MainApplication.rudderClient.reset()
        }


    }

    fun identify() {
        MainApplication.rudderClient.identify("RudderStack_test_2",
            RudderTraits()
                .put("displayName","RandomName_2")
                .putName("RudderStack_2")
                .putAge("123")
                .putEmail("support@rudderstack.com24"),
            null
        )
    }

    fun track() {
        MainApplication.rudderClient.track("Custom Track Call_1",
            RudderProperty()
                .putValue("Track_Property_1", 123)
                .putValue("Track_Property_2", 123.234)
                .putValue("date", Date())
                .putValue("String_custom", "abc")
                .putValue("String_custom 123", "abc 2")
                .putValue("Null_Check", null)
                .putValue("array_of_Int", arrayOf<Int>(1, 2, 3))
                .putValue("feature_packs", arrayOf("MAPS", "DEV", "DATA"))
        )
    }

    fun screen() {
        MainApplication.rudderClient.screen("Track Call",
            RudderProperty()
                .putValue("size", "1080pixel")
                .putValue("width", "7")
        )
    }
}
