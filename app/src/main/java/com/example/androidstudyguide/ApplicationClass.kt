package com.example.androidstudyguide

import android.app.Application
import android.content.Context
import com.example.androidstudyguide.di.BaseDependencyGraph
import com.example.androidstudyguide.di.DependencyGraph

class ApplicationClass : Application() {

    val dependencyGraph: DependencyGraph = BaseDependencyGraph()
}

fun Context.dependencyGraph(): DependencyGraph {
    return (this.applicationContext as ApplicationClass).dependencyGraph
}
