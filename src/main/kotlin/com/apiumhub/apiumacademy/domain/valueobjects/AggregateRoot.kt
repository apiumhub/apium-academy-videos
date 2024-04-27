package com.apiumhub.apiumacademy.domain.valueobjects

import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PostLoad
import jakarta.persistence.PrePersist
import jakarta.persistence.Version
import org.springframework.data.domain.Persistable

@MappedSuperclass
abstract class AggregateRoot<ID : EntityId> : Persistable<ID> {

    @Version
    private val version: Long? = null

    @Transient
    private var isNew: Boolean = true

    override fun isNew() = isNew

    @PostLoad
    @PrePersist
    fun trackNotNew() {
        isNew = false
    }
}