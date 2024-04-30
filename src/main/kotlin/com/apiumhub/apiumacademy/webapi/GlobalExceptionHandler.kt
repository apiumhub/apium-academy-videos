package com.apiumhub.apiumacademy.webapi

import com.apiumhub.apiumacademy.domain.exceptions.StudentsInCourseLimitReachedException
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.security.SignatureException
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AccountStatusException
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(StudentsInCourseLimitReachedException::class)
    fun handleStudentNotFoundException(exception: StudentsInCourseLimitReachedException)=
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.message)

    @ExceptionHandler(Exception::class)
    fun handleSecurityException(exception: Exception): ProblemDetail {
        var errorDetail: ProblemDetail? = null

        // TODO send this stack trace to an observability tool
        exception.printStackTrace()

        if (exception is BadCredentialsException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), exception.message)
            errorDetail.setProperty("description", "The username or password is incorrect")

            return errorDetail
        }

        if (exception is AccountStatusException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.message)
            errorDetail.setProperty("description", "The account is locked")
        }

        if (exception is AccessDeniedException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.message)
            errorDetail.setProperty("description", "You are not authorized to access this resource")
        }

        if (exception is SignatureException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.message)
            errorDetail.setProperty("description", "The JWT signature is invalid")
        }

        if (exception is ExpiredJwtException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.message)
            errorDetail.setProperty("description", "The JWT token has expired")
        }

        if (errorDetail == null) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.message)
            errorDetail.setProperty("description", "Unknown internal server error.")
        }

        return errorDetail
    }
}