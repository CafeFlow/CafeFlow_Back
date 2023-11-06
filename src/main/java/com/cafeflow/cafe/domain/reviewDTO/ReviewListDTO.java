package com.cafeflow.cafe.domain.reviewDTO;

import com.cafeflow.cafe.domain.Cafe;
import com.cafeflow.cafe.domain.Review;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class ReviewListDTO {

    private Long id;
    private Long cafeId;
    private String comments;
    private Long rate;
    private LocalDateTime regiDate;


    public ReviewListDTO(Review review) {
        this.id = review.getId();
        this.cafeId = review.getCafeId();
        this.comments = review.getComments();
        this.rate = review.getRate();
        this.regiDate = review.getRegiDate();
    }
}
