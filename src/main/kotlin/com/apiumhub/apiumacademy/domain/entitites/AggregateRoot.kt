package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.EntityId
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Version
import org.springframework.data.domain.AbstractAggregateRoot

@MappedSuperclass
abstract class AggregateRoot<ID : EntityId> {
    @Version
    private val version: Long? = null
}