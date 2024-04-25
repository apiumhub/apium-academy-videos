package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.AggregateRoot
import com.apiumhub.apiumacademy.domain.valueobjects.EntityId
import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import java.util.*

@Embeddable
class CourseId(override val id: UUID) : EntityId()

@Entity
class Course(override val id: CourseId, val name: String) : AggregateRoot<CourseId>(id)