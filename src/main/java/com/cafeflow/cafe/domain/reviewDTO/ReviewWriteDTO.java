package com.cafeflow.cafe.domain.reviewDTO;

import com.cafeflow.cafe.domain.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
public class ReviewWriteDTO {
    //Member member - 실명 리뷰때 사용

    private Long cafeId;
    private String title;
    private String comments;
    private Long rate;
    private LocalDateTime regiDate;

    @Builder
    public ReviewWriteDTO(Long cafeId, String comments, Long rate, LocalDateTime regiDate) {
        this.cafeId = cafeId;
        this.comments = comments;
        this.rate = rate;
        this.regiDate = LocalDateTime.now();
    }

    public Review toEntity(){

        return Review.builder()
                .cafeId(this.cafeId)
                .comments(comments)
                .rate(rate)
                .regiDate(regiDate)
                .build();
    }
}
