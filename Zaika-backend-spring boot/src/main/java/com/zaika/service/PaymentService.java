package com.zaika.service;

import com.stripe.exception.StripeException;
import com.zaika.model.Order;
import com.zaika.model.PaymentResponse;

public interface PaymentService {
	
	public PaymentResponse generatePaymentLink(Order order) throws StripeException;

}
