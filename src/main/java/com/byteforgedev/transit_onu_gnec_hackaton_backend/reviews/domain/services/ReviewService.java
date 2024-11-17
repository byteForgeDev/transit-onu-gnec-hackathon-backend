package com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.domain.services;

import java.util.List;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.domain.entity.Review;

public interface ReviewService {
    List<Review> getReviews(Long routeId, String sort);

    Review save(Review request);
}
