//package com.example.gatewayserver.config;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseCookie;
//import reactor.core.publisher.Mono;
//
//@Component
//public class AuthFilter implements GlobalFilter, Ordered {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        HttpHeaders headers = request.getHeaders();
//        String username = headers.getFirst(HttpHeaders.COOKIE);
//
//        // 如果 Cookie 中存在 username，且不为空，则继续执行请求
//        if (username != null && !username.isEmpty()) {
//            return chain.filter(exchange);
//        } else {
//            // 否则进行拦截并重定向到登录页面
//            ServerHttpResponse response = exchange.getResponse();
//            response.setStatusCode(HttpStatus.SEE_OTHER);
//            response.getHeaders().set(HttpHeaders.LOCATION, "/login");
//            return response.setComplete();
//        }
//    }
//    @Override
//    public int getOrder() {
//        return Ordered.LOWEST_PRECEDENCE;
//    }
//}
