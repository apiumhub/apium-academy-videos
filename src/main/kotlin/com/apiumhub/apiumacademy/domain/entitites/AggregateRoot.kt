package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.EntityId
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PostLoad
import jakarta.persistence.PrePersist
import jakarta.persistence.Version
import org.springframework.data.domain.AbstractAggregateRoot
import org.springframework.data.domain.Persistable

@MappedSuperclass
abstract class AggregateRoot<T : AbstractAggregateRoot<T>, ID : EntityId> :
    AbstractAggregateRoot<T>(),
    Persistable<ID> {

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