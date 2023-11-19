package com.cafeflow.cafe.domain;

import com.cafeflow.cafe.domain.reviewDTO.ReviewEditDTO;
import com.cafeflow.cafe.domain.reviewDTO.ReviewListDTO;
import com.cafeflow.cafe.domain.reviewDTO.ReviewWriteDTO;
import com.cafeflow.cafe.exception.NonExistentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<ReviewListDTO> reviewListDescendingByCafeId(Long cafeId){
        List<Review> reviews = reviewRepository.findAllByCafeIdOrderByIdDesc(cafeId);
        List<ReviewListDTO> reviewList = new ArrayList<>();

        int reviewNumber = reviews.size();
        for (Review review : reviews) {
            ReviewListDTO reviewDTO = ReviewListDTO.builder()
                    .id(review.getId())
                    .cafeId(review.getCafeId())
                    .comments(review.getComments())
                    .rate(review.getRate())
                    .regiDate(review.getRegiDate())
                    .reviewNum((long) reviewNumber--)
                    .build();
            reviewList.add(reviewDTO);
        }

        return reviewList;
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

    public double calculateAverageRatingForCafe(Long cafeId){
        List<Review> reviews = reviewRepository.findByCafeId(cafeId);

        if(reviews.isEmpty()){
            return 0.0;
        }

        double totalRating = reviews.stream().mapToDouble(Review::getRate).sum();

        return Math.round((totalRating/reviews.size())*100) / 100.0;
    }
}
