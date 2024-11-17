package com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.application.ReviewServiceImpl;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.domain.entity.Review;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(
            @RequestParam(required = false) Long routeId,
            @RequestParam(required = false, defaultValue = "none") String sort) {

        List<Review> reviews = reviewService.getReviews(routeId, sort);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/save")
    public ResponseEntity<Review> saveReview(@Valid @RequestBody Review request) {
        System.out.println("The request:");
        System.out.println(request.toString());
        Review newReview = reviewService.save(request);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }
}
