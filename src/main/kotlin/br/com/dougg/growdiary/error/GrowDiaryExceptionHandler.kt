package br.com.dougg.growdiary.error

import org.apache.logging.log4j.LogManager
import org.springframework.context.MessageSource
import org.springframework.context.NoSuchMessageException
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class GrowDiaryExceptionHandler(private val messageSource: MessageSource) {

    private val logger = LogManager.getLogger(this.javaClass)
    val NO_MESSAGE_AVAILABLE: String = "No message available"

    @ExceptionHandler(BusinessException::class)
    fun handlerBusinessException(exception: BusinessException, locale: Locale): ResponseEntity<ErrorResponse> {
        val errorCode: String = exception.errorCode
        val statusCode: HttpStatus = exception.statusCode

        val errorResponse = fromApiError(errorCode, locale, null)

        logger.error("BusinessExpcetion: Error Code -> {}, Message -> {}", errorCode, errorResponse.message)

        return ResponseEntity.status(statusCode).body(errorResponse)
    }

    @ExceptionHandler(NotFoundException::class)
    fun handlerNotFoundException(exception: NotFoundException, locale: Locale): ResponseEntity<ErrorResponse> {
        val errorCode: String = exception.errorCode
        val statusCode: HttpStatus = exception.statusCode

        val errorResponse = fromApiError(errorCode, locale, exception.stringNotFound)

        logger.error("NotFoundException: Error code -> {}, Message -> {}", errorCode, errorResponse.message)

        return ResponseEntity.status(statusCode).body(errorResponse)
    }

    private fun fromApiError(errorCode: String, locale: Locale, stringNotFound: String?): ErrorResponse {
        var message: String
        try {
            message = messageSource.getMessage(errorCode, arrayOf(stringNotFound), locale)
        } catch (e: NoSuchMessageException) {
            logger.error("Could not find any message for {} code under {} locale", errorCode, locale)
            message = NO_MESSAGE_AVAILABLE
        }

        return ErrorResponse(errorCode, message)
    }
}