package br.com.dougg.growdiary.error

import org.springframework.http.HttpStatus
import java.lang.RuntimeException

open class NotFoundException(
        val errorCode: String,
        val stringNotFound: String,
        val statusCode: HttpStatus
) : RuntimeException()