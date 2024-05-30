package com.apiumhub.apiumacademy.domain.valueobjects

import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PostLoad
import jakarta.persistence.PrePersist
import org.springframework.data.domain.Persistable

@MappedSuperclass
abstract class AggregateRoot<ID : EntityId>