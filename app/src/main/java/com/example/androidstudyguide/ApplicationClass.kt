package com.example.androidstudyguide

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * The application class is where we should configure any application wide
 * dependencies or libraries, such as Dagger-Hilt annotation [HiltAndroidApp].
 */
@HiltAndroidApp
class ApplicationClass : Application()
