package com.android.buildlogic.android.plugins

import com.android.buildlogic.android.components.setup.TestSetup
import com.android.buildlogic.common.plugins.BasePlugin
import com.android.buildlogic.common.utils.ComponentProvider
import org.gradle.api.Project

class TestConventionPlugin : BasePlugin() {
    override fun apply(target: Project) {
        super.apply(target)
        val testConventionPlugin: TestSetup = ComponentProvider.provide(target)
        testConventionPlugin.setup()
    }
}
