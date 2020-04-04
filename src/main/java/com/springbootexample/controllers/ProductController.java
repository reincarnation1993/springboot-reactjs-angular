package com.springbootexample.controllers;

import com.springbootexample.dtos.GenericResponseObject;
import com.springbootexample.dtos.product.ProductResponse;
import com.springbootexample.entities.User;
import com.springbootexample.services.product.ProductServiceImpl;
import com.springbootexample.services.user.UserServiceImpl;
import com.springbootexample.utils.ConstantsUtils;
import com.springbootexample.utils.jwt.JwtUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    private ProductServiceImpl productServiceImpl;
    private JwtUtil jwtUtil;
    private UserServiceImpl userServiceImpl;

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl, JwtUtil jwtUtil, UserServiceImpl userServiceImpl) {
        this.productServiceImpl = productServiceImpl;
        this.jwtUtil = jwtUtil;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/api/products")
    public ResponseEntity<GenericResponseObject<Object>> index(@RequestHeader Map<String, String> headers) {
        try {
            String accessToken = jwtUtil.getTokenFromHeaders(headers);
            List<User> user = userServiceImpl.findById(jwtUtil.getUserIdFromJWT(accessToken));
            if (CollectionUtils.isNotEmpty(user) && jwtUtil.validateToken(accessToken)) {
                return ResponseEntity.ok().body(GenericResponseObject.builder()
                        .timestamp(LocalDateTime.now())
                        .message(ConstantsUtils.getSUCCESS())
                        .status(ConstantsUtils.getResponseSuccess())
                        .data(productServiceImpl.findAll().stream().map(data -> ProductResponse.builder()
                                .key(data.getIdentifier())
                                .name(data.getName())
                                .expireDate(data.getExpireDate())
                                .build()
                        )).build());
            } else {
                return ResponseEntity.ok().body(GenericResponseObject.builder()
                        .timestamp(LocalDateTime.now())
                        .message(ConstantsUtils.getUserInvalidMsg())
                        .status(ConstantsUtils.getResponseBadRequest())
                        .build()
                );
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.ok()
                    .body(GenericResponseObject.builder()
                            .timestamp(LocalDateTime.now())
                            .message(ConstantsUtils.getInternalServerErrorMsg())
                            .status(ConstantsUtils.getResponseInternalServerError())
                            .build()
                    );
        }

    }
}

