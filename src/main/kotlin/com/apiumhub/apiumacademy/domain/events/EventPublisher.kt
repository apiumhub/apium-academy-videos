package com.apiumhub.apiumacademy.domain.events

import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.entitites.auth.RoleEnum
import com.apiumhub.apiumacademy.domain.repositories.StudentRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
internal class DomainEventListener(private val studentRepository: StudentRepository) {
    @EventListener
    @Async
    fun onApplicationEvent(event: UserEvent) {
        when (event) {
            is UserRolesGrantedEvent -> processRolesGrantedEvent(event)
        }
        println("New DomainEvent arrived '$event'")
    }

    private fun processRolesGrantedEvent(event: UserRolesGrantedEvent) {
        if (event.grantedRoles.contains(RoleEnum.STUDENT)) {
            val newStudent = Student.createFromUser(event.aggregateId)
            studentRepository.save(newStudent)
        }
    }
}