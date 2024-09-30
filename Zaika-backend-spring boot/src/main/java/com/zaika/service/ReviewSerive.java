package com.zaika.service;

import java.util.List;

import com.zaika.Exception.ReviewException;
import com.zaika.model.Review;
import com.zaika.model.User;
import com.zaika.request.ReviewRequest;

public interface ReviewSerive {
	
    public Review submitReview(ReviewRequest review,User user);
    public void deleteReview(Long reviewId) throws ReviewException;
    public double calculateAverageRating(List<Review> reviews);
}
