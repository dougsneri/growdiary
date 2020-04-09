package br.com.dougg.growdiary

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrowdiaryApplication

fun main(args: Array<String>) {
	runApplication<GrowdiaryApplication>(*args)
}
