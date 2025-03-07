package com.example.repository.abstracts;

import com.example.core.abstracts.BaseRepository;
import com.example.entities.concretes.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends BaseRepository<Course,Long> {
    List<Course> findByInstructorId(Long instructorId);
    List<Course> findByIsPublishedTrue();
    List<Course> findByCategoriesId(Long categoryId);
}
