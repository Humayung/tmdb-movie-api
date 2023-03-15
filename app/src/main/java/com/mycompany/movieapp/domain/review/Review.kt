package com.mycompany.movieapp.domain.review

data class Review(
    val id: String?,
    val author: String?,
    val content: String?,
    val createdAt: String?,
    val updatedAt: String?,
    val authorDetails: AuthorDetails?
)