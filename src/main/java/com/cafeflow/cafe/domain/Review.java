package com.cafeflow.cafe.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

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
