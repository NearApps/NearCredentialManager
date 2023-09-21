package io.github.nearapps.credential_manager

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application(){

    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate() {
        super.onCreate()

        initialize_firebase()
    }

    fun initialize_firebase(){
        analytics = Firebase.analytics
    }
}