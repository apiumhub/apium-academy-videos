package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.teacher.teacherId.TeacherId
import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import jakarta.persistence.*

@Table(name = "Teachers")
@Entity
class Teacher private constructor(
    @EmbeddedId val teacherId: TeacherId,
) : AggregateRoot<TeacherId>() {
    companion object {
        fun create() = Teacher(TeacherId())
        fun createFromUser(userId: UserId) = Teacher(TeacherId(userId.id))
    }
}

//@Entity
//@Table(name = "course_teacher")
//@IdClass(CourseTeacherId::class)
//class CourseTeacher(
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "teacher", referencedColumnName = "id")
//    val teacher: Teacher,
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "course", referencedColumnName = "id")
//    val course: Course
//)
//
//class CourseTeacherId(val teacher: Teacher, val course: Course)