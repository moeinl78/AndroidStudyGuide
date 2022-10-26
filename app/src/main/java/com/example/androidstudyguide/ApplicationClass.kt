package com.example.androidstudyguide

import android.app.Application
import com.example.androidstudyguide.di.BaseDependencyGraph
import com.example.androidstudyguide.di.DependencyGraph

class ApplicationClass : Application() {

    val dependencyGraph: DependencyGraph = BaseDependencyGraph()
}