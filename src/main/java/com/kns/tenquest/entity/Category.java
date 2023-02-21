package com.kns.tenquest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data // setter 없도록 수정필요 -> 생성자랑 게터는 만들어야함
@Table(name="category_table")
@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Id
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;
}
