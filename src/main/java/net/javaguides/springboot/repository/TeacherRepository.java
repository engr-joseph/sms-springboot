package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
