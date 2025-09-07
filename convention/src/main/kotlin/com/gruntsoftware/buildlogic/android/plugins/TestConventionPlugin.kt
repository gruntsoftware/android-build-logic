package com.gruntsoftware.buildlogic.android.plugins

import com.gruntsoftware.buildlogic.android.components.setup.TestSetup
import com.gruntsoftware.buildlogic.common.plugins.BasePlugin
import com.gruntsoftware.buildlogic.common.utils.ComponentProvider
import org.gradle.api.Project

class TestConventionPlugin : BasePlugin() {
    override fun apply(target: Project) {
        super.apply(target)
        val testConventionPlugin: TestSetup = ComponentProvider.provide(target)
        testConventionPlugin.setup()
    }
}
