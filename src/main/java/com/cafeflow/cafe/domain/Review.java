package com.cafeflow.cafe.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
    private String regiDate;

    public void update(String comments, Long rate){
        this.comments = comments;
        this.rate = rate;
    }

    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDate = localDateTime.format(formatter);

        return formattedDate;
    }
}
