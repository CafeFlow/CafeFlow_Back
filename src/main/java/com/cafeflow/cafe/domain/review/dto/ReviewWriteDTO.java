package com.cafeflow.cafe.domain.review.dto;

import com.cafeflow.cafe.domain.review.entity.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Getter
@NoArgsConstructor
public class ReviewWriteDTO {
    //Member member - 실명 리뷰때 사용

    private Long cafeId;
    private String comments;
    private Long rate;
    private Long regiDate;

    @Builder
    public ReviewWriteDTO(Long cafeId, String comments, Long rate, Long regiDate) {
        this.cafeId = cafeId;
        this.comments = comments;
        this.rate = rate;
        this.regiDate = regiDate;
    }

    public Review toEntity(Long cafeId){

        LocalDateTime regiDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        return Review.builder()
                .cafeId(cafeId)
                .comments(comments)
                .rate(rate)
                .regiDate(String.valueOf(regiDateTime))
                .build();
    }
}
