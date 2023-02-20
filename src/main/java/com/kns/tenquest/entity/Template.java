package com.kns.tenquest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name="template_table")
@Entity
public class Template {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Id
    @Column(name="template_id")
    private UUID templateId;

    @Column(name="template_name")
    private String templateName;

    @Column(name="created_at")
    private LocalDateTime createdAt;


    //@ManyToOne // Many = Template , One = Member  : 한개의 카테고리는. .여러개의 질문객체를 가질수있다 . : hibernate 에서는 못씀
    @JoinColumn(name="member_id")  //이부분 맞는지 잘모르겠음 확인해봐야됨 다시
    @Column(name="template_owner")
    private UUID templateOwner;

    @Column(name="template_is_public")
    private boolean isPublic;

}
