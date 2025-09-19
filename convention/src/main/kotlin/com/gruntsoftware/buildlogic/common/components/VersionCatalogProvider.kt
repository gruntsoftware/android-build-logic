package com.gruntsoftware.buildlogic.common.components

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam

@Factory
class VersionCatalogProvider(
    @InjectedParam private val project: Project,
    private val logger: BuildLogicLogger
) {

    val libs
        get(): VersionCatalog = project.getVersionCatalogByName(LIBS_NAME)

    val grunt
        get(): VersionCatalog = project.getVersionCatalogByName(GRUNT_NAME)

    fun getAll(): List<VersionCatalog> {
        return listOf(
            libs,
            grunt
        ).sortedBy {
            it.name == "libs"
        }
    }

    private fun Project.getVersionCatalogByName(name: String): VersionCatalog {
        return runCatching {
            extensions.getByType<VersionCatalogsExtension>().named(name)
        }.getOrElse {
            this@VersionCatalogProvider.logger.i(TAG, "Cannot find version catalog named: $name")
            this@VersionCatalogProvider.logger.i(
                TAG,
                "please add version catalog on your setting.gradle.kts first"
            )
            throw it
        }
    }

    companion object {
        private const val TAG = "VersionCatalogProvider"
        private const val LIBS_NAME = "libs"
        private const val GRUNT_NAME = "grunt"
    }
}
