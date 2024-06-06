//package com.example.gatewayserver.config;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//import reactor.core.publisher.Mono;
//import java.net.URI;
//@Component
//public class AuthFilter implements WebFilter {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        String path = exchange.getRequest().getURI().getPath();
//        // 不拦截 /dev-html/spots 和 /dev-html/login 的请求
//        if (path.equals("/dev-html/spots") || path.equals("/dev-html/login") || path.equals("/dev-user/getLogin")) {
//            return chain.filter(exchange);
//        }
//        // 判断会话中是否有 userLoggedIn 属性
//        return exchange.getSession().flatMap(webSession -> {
//            Boolean userLoggedIn = (Boolean) webSession.getAttribute("userLoggedIn");
//            if (userLoggedIn != null && userLoggedIn) {
//                return chain.filter(exchange);
//            } else {
//                // 未登录，重定向到登录页面
//                exchange.getResponse().setStatusCode(HttpStatus.SEE_OTHER);
//                exchange.getResponse().getHeaders().setLocation(URI.create("/dev-html/login"));
//                return exchange.getResponse().setComplete();
//            }
//        });
//    }
//}
//
//
