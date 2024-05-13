package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.EntityId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "Students")
class Student private constructor(
    @EmbeddedId val studentId: StudentId
) : AggregateRoot<StudentId>() {
    companion object {
        fun create() = Student(StudentId())
        fun createFromUser(userId: UserId) = Student(StudentId(userId.id))
    }
}

@Entity
@Table(name = "course_student")
class CourseStudent private constructor(
    @EmbeddedId val courseStudentId: CourseStudentId,
    @AttributeOverride(name = "id", column = Column(name = "course_id"))
    val courseId: CourseId,
    @AttributeOverride(name = "id", column = Column(name = "student_id"))
    val studentId: StudentId
) : AggregateRoot<CourseStudentId>() {

    companion object {
        fun create(course: Course, student: Student) =
            CourseStudent(CourseStudentId(), course.courseId, student.studentId)
    }
}

@Embeddable
class CourseStudentId(override val id: UUID) : EntityId() {
    constructor(id: String) : this(UUID.fromString(id))
    constructor() : this(UUID.randomUUID())
}