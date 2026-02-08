package com.android.buildlogic.common.plugins

import com.android.buildlogic.common.components.DetektSetup
import com.android.buildlogic.common.utils.ComponentProvider
import org.gradle.api.Project

class DetektConventionPlugin : BasePlugin() {
    override fun apply(target: Project) {
        super.apply(target)
        val detektSetup: DetektSetup = ComponentProvider.provide(target)
        detektSetup.setup()
    }
}
