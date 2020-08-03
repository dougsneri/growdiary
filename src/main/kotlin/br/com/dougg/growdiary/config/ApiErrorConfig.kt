package br.com.dougg.growdiary.config

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource

@Configuration
class ApiErrorConfig {

    @Bean
    fun apiErrorMessageSource(): MessageSource {
        val messageSource = ReloadableResourceBundleMessageSource()
        messageSource.setBasename("classpath:/messages")
        messageSource.setDefaultEncoding("UTF-8")

        return messageSource
    }
}