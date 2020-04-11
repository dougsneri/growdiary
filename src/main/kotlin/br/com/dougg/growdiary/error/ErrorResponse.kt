package br.com.dougg.growdiary.error

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorResponse(
        @JsonProperty("error_code")
        val errorCode: String,
        val message: String
)