package com.gruntsoftware.buildlogic.common.components

import com.gruntsoftware.buildlogic.common.utils.C
import org.koin.core.annotation.Single

@Single
class BuildLogicLogger {

    fun i(message: String) {
        printMessage(message)
    }

    fun title(tag: String, message: String) {
        i("=======================================================================================")
        i(tag, message)
        i("=======================================================================================")
    }

    fun i(tag: String, message: String) {
        printMessage(message, tag)
    }

    private fun printMessage(
        msg: String,
        tag: String? = null,
    ) {
        val assignee = if (!tag.isNullOrBlank()) "[$tag]" else ""
        println("${C.GLOBAL_TAG}$assignee: $msg")
    }
}