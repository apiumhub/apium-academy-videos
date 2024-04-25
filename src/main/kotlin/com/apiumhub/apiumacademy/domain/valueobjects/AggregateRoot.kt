package com.apiumhub.apiumacademy.domain.valueobjects

import jakarta.persistence.EmbeddedId
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class AggregateRoot<T : EntityId>(@EmbeddedId open val id: T)