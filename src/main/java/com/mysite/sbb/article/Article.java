package com.mysite.sbb.article;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDateTime createDate;
    /*
    2025-08-06T21:02:35.740+09:00  INFO 13572 --- [sbb] [nio-8088-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
            2025-08-06T21:02:35.741+09:00  INFO 13572 --- [sbb] [nio-8088-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
    Hibernate: select a1_0.id,a1_0.content,a1_0.create_date,a1_0.title from article a1_0*/
    // @ManyToOne
    // private Article article;
}
