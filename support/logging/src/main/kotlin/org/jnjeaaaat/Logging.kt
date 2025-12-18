package org.jnjeaaaat

import io.github.oshai.kotlinlogging.KotlinLogging

inline fun <reified T : Any> T.logger() =
    KotlinLogging.logger(T::class.java.name)