package com.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Repository 대신 사용한것
public interface PostsRepository extends JpaRepository<Posts, Long> { // post = PK , Long = PK type

    @Query("SELECT p FROM Posts p Order BY p.id DESC")
    List<Posts> findAllDesc();
}
