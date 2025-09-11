package com.gruntsoftware.buildlogic.android.components.dependency

import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.koin.core.component.KoinComponent

interface DependenciesApplicator : KoinComponent {
    fun implementation(notation: Provider<MinimalExternalModuleDependency>)
    fun implementation(alias: String)
    fun implementations(vararg alias: String)
    fun kapt(notation: Provider<MinimalExternalModuleDependency>)
    fun kapt(alias: String)
    fun ksp(notation: Provider<MinimalExternalModuleDependency>)
    fun ksp(alias: String)
    fun implementationPlatform(notation: Provider<MinimalExternalModuleDependency>)
    fun implementationPlatform(alias: String)
    fun apiPlatform(notation: Provider<MinimalExternalModuleDependency>)
    fun apiPlatform(alias: String)
    fun testImplementationPlatform(notation: Provider<MinimalExternalModuleDependency>)
    fun testImplementationPlatform(alias: String)
    fun androidTestImplementationPlatform(notation: Provider<MinimalExternalModuleDependency>)
    fun androidTestImplementationPlatform(alias: String)
    fun androidTestImplementation(notation: Provider<MinimalExternalModuleDependency>)
    fun androidTestImplementation(alias: String)
    fun debugImplementation(notation: Provider<MinimalExternalModuleDependency>)
    fun debugImplementation(alias: String)
    fun debugImplementations(vararg alias: String)
    fun testImplementation(notation: Provider<MinimalExternalModuleDependency>)
    fun testImplementation(alias: String)
    fun detektPlugin(notation: Provider<MinimalExternalModuleDependency>)
    fun detektPlugin(alias: String)
    fun detektPlugins(vararg aliases: String)
    fun testImplementations(vararg alias: String)
    fun androidTestImplementations(vararg alias: String)
}
