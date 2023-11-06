package com.cafeflow.cafe.domain.reviewDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewEditDTO {
        private String comments;
        private Long rate;
        @Builder
        public ReviewEditDTO(String comments, Long rate) {
            this.comments = comments;
            this.rate = rate;
        }
}
