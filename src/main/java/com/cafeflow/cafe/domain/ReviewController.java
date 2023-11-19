package com.cafeflow.cafe.domain;

import com.cafeflow.cafe.domain.reviewDTO.ReviewEditDTO;
import com.cafeflow.cafe.domain.reviewDTO.ReviewListDTO;
import com.cafeflow.cafe.domain.reviewDTO.ReviewWriteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cafe")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    CafeRepository cafeRepository;

    @GetMapping("/{cafe}/reviews")
    public ResponseEntity reviewList(@PathVariable("cafe") Long cafeId){
        List<ReviewListDTO> reviewList = reviewService.reviewListDescendingByCafeId(cafeId);

        int tmpSize = reviewList.size();

        double averageRating = reviewService.calculateAverageRatingForCafe(cafeId);

        Cafe cafe = cafeRepository.findById(cafeId).orElse(null);
        String cafeName = cafe.getName();

        Map<String, Object> res = new HashMap<>();
        res.put("reviewList", reviewList);
        res.put("averRating", averageRating);
        res.put("reviewSize", tmpSize);
        res.put("cafeName", cafeName);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/{cafe}/reviews")
    public ResponseEntity writeReview(@PathVariable("cafe") Long cafeId, @RequestBody ReviewWriteDTO reviewDTO){
        Review review = reviewService.writeReview(reviewDTO, cafeId);
        return ResponseEntity.status(HttpStatus.OK).body(review);
    }

    @PutMapping("/{cafe}/reviews/{reviewId}")
    public ResponseEntity editReview(@PathVariable("cafe") Long cafeId, @PathVariable("reviewId") Long id, @RequestBody ReviewEditDTO reviewDTO){
        Review review = reviewService.editReview(id, reviewDTO);
        return ResponseEntity.status(HttpStatus.OK).body(review);
    }

    @DeleteMapping("/{cafe}/reviews/{reviewId}")
    public ResponseEntity deleteReview(@PathVariable("cafe") Long cafeId, @PathVariable("reviewId") Long id){
        Review review = reviewService.deleteReview(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(review);
    }
}
