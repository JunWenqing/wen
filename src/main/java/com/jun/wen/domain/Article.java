package com.jun.wen.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Locale;

@Data
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", columnDefinition = "varchar(64) binary")
    private String id;

    private String title;
    @Column(name = "content", columnDefinition = "text")
    private String content;

    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "summary", columnDefinition = "text")
    private String summary;

    @Column(name = "date", columnDefinition = "text")
    private String date;
}
