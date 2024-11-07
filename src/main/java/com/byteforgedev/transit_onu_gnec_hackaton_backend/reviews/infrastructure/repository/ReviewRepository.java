package com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.domain.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    List<Review> findByRouteId(@Param("routeId") Long routeId);

    
    List<Review> findByRouteIdOrderByStarsDesc(@Param("routeId") Long routeId);

    
    List<Review> findByRouteIdOrderByStarsAsc(@Param("routeId") Long routeId);

    @Query("SELECT r FROM Review r ORDER BY r.stars DESC")
    List<Review> findAllOrderByStarsDesc();

    @Query("SELECT r FROM Review r ORDER BY r.stars ASC")
    List<Review> findAllOrderByStarsAsc();
}
