package com.cafeflow.cafe.domain.reviewDTO;

import com.cafeflow.cafe.domain.Cafe;
import com.cafeflow.cafe.domain.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ReviewListDTO {

    private Long id;
    private Long cafeId;
    private String comments;
    private Long rate;
    private String regiDate;

    private Long reviewNum;


    @Builder
    public ReviewListDTO(Long id, Long cafeId, String comments, Long rate, String regiDate, Long reviewNum) {
        this.id = id;
        this.cafeId = cafeId;
        this.comments = comments;
        this.rate = rate;
        this.regiDate = regiDate;
        this.reviewNum = reviewNum;
    }
}
