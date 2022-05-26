package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PostRepository extends JpaRepository<Post,Long>{
    //Spring Data JPA 가 인터페이스 대해 프록시 구현체를 만든 뒤 DI

}
