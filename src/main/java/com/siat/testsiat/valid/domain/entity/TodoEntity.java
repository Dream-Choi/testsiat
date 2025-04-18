package com.siat.testsiat.valid.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "jpa_todo_entity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int seq;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "phone")
    private String phone;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "status")
    private String status;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "priority")
    private int priority;
}
