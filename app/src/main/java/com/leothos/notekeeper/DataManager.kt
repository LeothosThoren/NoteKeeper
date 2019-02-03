package com.leothos.notekeeper

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intent", "Android Programming with Intent")
        courses.set(course.courseId, course)

        course = CourseInfo(title = "Android Async Programming and Services", courseId = "android_async")
        courses.set(course.courseId, course)

        course = CourseInfo("java_lang", "Java Fundamentals: The Java Language")
        courses.set(course.courseId, course)

        course = CourseInfo("java_core", "Java Fundamentals: The Java Core")
        courses.set(course.courseId, course)
    }

    private fun initializeNotes() {
        var course = CourseInfo("android_intent", "Android Programming with Intent")
        courses.set(course.courseId, course)
        notes.add(NoteInfo(course, "my title", course.title))

        course = CourseInfo("android_service", "Android Programming with Service")
        courses.set(course.courseId, course)
        notes.add(NoteInfo(course, "title service", course.title))
    }
}