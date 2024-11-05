package com.byteforgedev.transit_onu_gnec_hackaton_backend.reviews.domain.entity;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity.User;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.routes.domain.entity.Route;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please add a title for the review")
    @Size(min = 4, max = 100, message = "The title must have minimum 4 and maximum 100 characters")
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String title;

    @NotNull(message = "Please add a star rating for the review")
    @Min(value = 1, message = "The rating must be at least 1")
    @Max(value = 5, message = "The rating must be at most 5")
    @Column(columnDefinition = "SMALLINT", nullable = false)
    private Integer stars;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Embedded
    @Builder.Default
    private Audit audit = new Audit();

    @NotNull(message = "You must be an user to make a review")
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = true, updatable = true, nullable = false)
    private User user;

    @NotNull(message = "The review must be associated with a route")
    @ManyToOne
    @JoinColumn(name = "route_id", insertable = true, updatable = true, nullable = false)
    private Route route;
}
