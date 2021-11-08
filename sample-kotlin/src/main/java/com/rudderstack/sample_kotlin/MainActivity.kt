package com.rudderstack.sample_kotlin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fullstory.FS
import com.rudderstack.android.sdk.core.RudderProperty
import com.rudderstack.android.sdk.core.RudderTraits

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

        val group = findViewById<Button>(R.id.group)
        group?.setOnClickListener {
            group()
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
        MainApplication.rudderClient.identify("RudderStack_User_5",
            RudderTraits()
                .put("name2","RandomName_3")
                .putName("RudderStack_3")
                .putAge("123")
                .putEmail("support@rudderstack.com3"),
            null
        )
    }

    fun group() {
        MainApplication.rudderClient.group("RudderStack_User_Group",
            RudderTraits()
                .put("name3","RandomName_Group")
                .putName("RudderStackGroup")
                .putAge("12")
                .putEmail("group@rudderstack.com"),
            null
        )
    }

    fun track() {
        MainApplication.rudderClient.track("Custom Track Call",
            RudderProperty()
                .putValue("Track_Property_1", 123)
                .putValue("Track_Property_2", 123.234)
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
