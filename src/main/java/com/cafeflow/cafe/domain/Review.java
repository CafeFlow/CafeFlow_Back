package com.cafeflow.cafe.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cafeId;
    private String comments;
    private Long rate;
    private LocalDateTime regiDate;

    public void update(String comments, Long rate){
        this.comments = comments;
        this.rate = rate;
    }


}
