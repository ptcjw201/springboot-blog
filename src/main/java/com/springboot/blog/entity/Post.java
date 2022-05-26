package com.springboot.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
// Getter, Setter, ToString 등의 함수들을 생성해줌
@AllArgsConstructor
//클래스의 모든 필드에 대한 생성자 자동 생성
@NoArgsConstructor
//파라미터가 없는 생성자 자동 생성
@Entity
//엔티티 지정
@Table(
        name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
//name -> 매필할 테이플 이름
//UniqueConstraint -> DDL 생성시 제약조건을 만듦

public class Post {

    @Id
    //키 매핑, 자동생성
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    //기본 키 생성을 DB에 위임 (ex:id를 NULL로 하면 DB가 알아서 Increment)
    private Long id;

    @Column(name = "title", nullable = false)
    //객체 필드를 테이블의 컬럼에 매핑
    private String title;
    
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();
}
