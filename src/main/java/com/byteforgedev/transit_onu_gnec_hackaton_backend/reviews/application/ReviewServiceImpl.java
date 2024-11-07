package com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.domain.entity.Review;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.domain.services.ReviewService;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.infrastructure.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getReviews(Long routeId, String sort) {
        if (routeId != null) {
            // Filter by route ID
            if ("most".equalsIgnoreCase(sort)) {
                return reviewRepository.findByRouteIdOrderByStarsDesc(routeId);
            } else if ("least".equalsIgnoreCase(sort)) {
                return reviewRepository.findByRouteIdOrderByStarsAsc(routeId);
            } else {
                return reviewRepository.findByRouteId(routeId);
            }
        } else {
            // No route filter
            if ("most".equalsIgnoreCase(sort)) {
                return reviewRepository.findAllOrderByStarsDesc();
            } else if ("least".equalsIgnoreCase(sort)) {
                return reviewRepository.findAllOrderByStarsAsc();
            } else {
                return reviewRepository.findAll();
            }
        }
    }
}
