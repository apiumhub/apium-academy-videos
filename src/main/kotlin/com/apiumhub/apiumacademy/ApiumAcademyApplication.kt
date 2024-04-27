package com.apiumhub.apiumacademy

import org.springframework.boot.autoconfigure.AutoConfigurationPackage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiumAcademyApplication

fun main(args: Array<String>) {
    runApplication<ApiumAcademyApplication>(*args)
}
