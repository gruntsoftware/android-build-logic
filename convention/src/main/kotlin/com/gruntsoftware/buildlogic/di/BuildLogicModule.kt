package com.gruntsoftware.buildlogic.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan(
    "com.gruntsoftware.buildlogic"
)
object BuildLogicModule
