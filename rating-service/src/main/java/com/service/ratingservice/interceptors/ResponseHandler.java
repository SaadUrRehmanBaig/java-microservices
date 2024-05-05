package com.service.ratingservice.interceptors;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.service.ratingservice.payload.ApiResponse;

@RestControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if ((body == null) || (body.getClass() != ApiResponse.class)) {
            ApiResponse<Object> apiResponse = new ApiResponse<>();
            apiResponse.setData(body);
            apiResponse.setMessage("Success");
            apiResponse.setSuccess(true);

            return apiResponse;
        }
        return body;
    }

}
