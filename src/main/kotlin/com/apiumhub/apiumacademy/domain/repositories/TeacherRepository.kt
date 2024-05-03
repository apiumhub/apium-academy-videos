package com.apiumhub.apiumacademy.domain.repositories

import com.apiumhub.apiumacademy.domain.entitites.Teacher
import com.apiumhub.apiumacademy.domain.valueobjects.teacher.teacherId.TeacherId
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepository : JpaRepository<Teacher, TeacherId>