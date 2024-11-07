package com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.domain.entity.Review;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.domain.services.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(
            @RequestParam(required = false) Long routeId,
            @RequestParam(required = false, defaultValue = "none") String sort) {

        List<Review> reviews = reviewService.getReviews(routeId, sort);
        return ResponseEntity.ok(reviews);
    }
}
