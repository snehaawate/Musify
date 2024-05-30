package com.example.musify.domain

import retrofit2.HttpException

/**
 * An enum that contains different error types associated with [HttpException.code].
 */
enum class MusifyErrorType {
    BAD_OR_EXPIRED_TOKEN,
    BAD_OAUTH_REQUEST,
    INVALID_REQUEST,
    RATE_LIMIT_EXCEEDED,
    UNKNOWN_ERROR,
    NETWORK_CONNECTION_FAILURE,
    RESOURCE_NOT_FOUND,
    DESERIALIZATION_ERROR
}

/**
 * An extension property on [retrofit2.HttpException] that indicates
 * the [MusifyErrorType] associated with the [retrofit2.HttpException.code]
 */
fun HttpException.getAssociatedMusifyErrorType(): MusifyErrorType =
    when (this.code()) {
        400 -> MusifyErrorType.INVALID_REQUEST
        401 -> MusifyErrorType.BAD_OR_EXPIRED_TOKEN
        403 -> MusifyErrorType.BAD_OAUTH_REQUEST
        429 -> MusifyErrorType.RATE_LIMIT_EXCEEDED
        404 -> MusifyErrorType.RESOURCE_NOT_FOUND
        else -> MusifyErrorType.UNKNOWN_ERROR
    }