package com.thymeleaf.test.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "game_results")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "word", nullable = false)
    private Word word;

    @Column(name = "attempts")
    private Long attempts;
}
