package com.thymeleaf.test.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "words")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "help_question")
    private String helpQuestion;
}
