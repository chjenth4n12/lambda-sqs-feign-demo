package com.example.demo.lambda;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.example.demo.model.FeignModel;
import com.example.demo.utils.FeignUtils;

public class LambdaDemo implements RequestHandler<SQSEvent, Void> {
	
	@Autowired
	FeignUtils feignUtils;

	@Override
	public Void handleRequest(SQSEvent input, Context context) {
		FeignModel result = feignUtils.getItem((long) 1);
		System.out.println(result);
		return null;
	}
}
