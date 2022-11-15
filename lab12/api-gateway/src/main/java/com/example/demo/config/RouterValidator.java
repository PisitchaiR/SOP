package com.example.demo.config;


import org.springframework.http.server.reactive.ServerHttpRequest;
import org. springframework.stereotype.Component;
import java. util. List;
import java. util. function. Predicate;

@Component
public class RouterValidator {
    public static final List<String> openApiEndPoints = list.of(
            "/auth/register",
            "/auth/login"
    );
    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
