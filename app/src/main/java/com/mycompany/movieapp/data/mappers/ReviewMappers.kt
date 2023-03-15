package com.mycompany.movieapp.data.mappers

import com.mycompany.movieapp.data.remote.AuthorDetailsDto
import com.mycompany.movieapp.data.remote.ReviewDto
import com.mycompany.movieapp.data.remote.ReviewsDataDto
import com.mycompany.movieapp.domain.review.AuthorDetails
import com.mycompany.movieapp.domain.review.Review
import com.mycompany.movieapp.domain.review.ReviewsData
import java.time.LocalDateTime

fun ReviewsDataDto.toReviewsData(): ReviewsData {
    return ReviewsData(
        id = id,
        page = page,
        results = results.map { it.toReview() },
        totalPages = total_pages,
        totalResults = total_results
    )

}

fun AuthorDetailsDto.toAuthorDetails(): AuthorDetails {
    return AuthorDetails(
        name = name,
        username = username,
        rating = rating,
        avatarPath = avatar_path
    )
}

fun ReviewDto.toReview(): Review {
    return Review(
        id = id,
        author = author,
        content = content,
        createdAt = created_at,
        updatedAt = updated_at,
        authorDetails = author_details?.toAuthorDetails()
    )
}