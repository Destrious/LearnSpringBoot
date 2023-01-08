package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository jdbcRepository;

    @Autowired
    private CourseJpaRepository jpaRepository;

    @Autowired
    private CourseSpringDataJpaRepository springJpaRepository;

    @Override
    public void run(String... args) throws Exception {

        // RUN JDBC REPOSITORY

        jdbcRepository.insert(new Course(1, "Learn AWS Now!", "in28minutes"));
        jdbcRepository.insert(new Course(2, "Learn Azure Now!", "in28minutes"));
        jdbcRepository.insert(new Course(3, "Learn DevOps Now!", "in28minutes"));
        jdbcRepository.deleteById(1);
        System.out.println(jdbcRepository.findById(2));
        System.out.println(jdbcRepository.findById(3));

        // NOW RUN JPA REPOSITORY

        jpaRepository.insert(new Course(4, "Learn Something now!", "in28minutes"));
        System.out.println(jpaRepository.findById(2));

        // NOW RUN SPRING JPA REPOSITORY

        System.out.println("RUNNING SPRING JPA");
        System.out.println(springJpaRepository.findById(2l));
        System.out.println(springJpaRepository.findById(3l));

//        System.out.println(springJpaRepository.findAll());
        System.out.println(springJpaRepository.findByAuthor("in28minutes"));
        System.out.println(springJpaRepository.findByName("Learn Nothing Now!"));
        System.out.println(springJpaRepository.findByName("Learn DevOps Now!"));

    }

}
