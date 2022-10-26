package com.example.androidstudyguide.di

/**
 * Defines application wide dependencies and sub graphs.
 */
interface DependencyGraph {
    val dataGraph: DataGraph
}

/**
 * This implementation is the production version of our dependency graph.
 */
class BaseDependencyGraph : DependencyGraph {
    override val dataGraph: DataGraph = NetworkDataGraph()
}
