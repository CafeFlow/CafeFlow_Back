package com.cafeflow.cafe.domain;

import com.cafeflow.cafe.domain.reviewDTO.ReviewEditDTO;
import com.cafeflow.cafe.domain.reviewDTO.ReviewListDTO;
import com.cafeflow.cafe.domain.reviewDTO.ReviewWriteDTO;
import com.cafeflow.cafe.exception.NonExistentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<ReviewListDTO> reviewListDescendingByCafeId(Long cafeId){
        return reviewRepository.findAllByCafeIdOrderByIdDesc(cafeId).stream()
                .map(ReviewListDTO::new)
                .collect(Collectors.toList());
    }

    public Review writeReview(ReviewWriteDTO reviewDTO, Long cafeId){
        return reviewRepository.save(reviewDTO.toEntity(cafeId));
    }

    public Review editReview(Long id, ReviewEditDTO reviewDTO){
        Review modifiedReview = reviewRepository.findById(id).orElseThrow(() ->
                new NonExistentException("존재하지 않는 게시물입니다."));

        modifiedReview.update(reviewDTO.getComments(), reviewDTO.getRate());
        return reviewRepository.save(modifiedReview);
    }
    public Review deleteReview(Long id){
        Review review = reviewRepository.findById(id).orElseThrow(() ->
                new NonExistentException("존재하지 않는 게시물입니다."));

        reviewRepository.delete(review);
        return review;
    }
}
