package com.example.controller;

import com.example.client.SpotDetailDataClient;
import com.example.model.Review;
import com.example.model.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class SpotDetailController {
    @Autowired
    private SpotDetailDataClient spotDetailDataClient;
    @GetMapping("/spotDetail")
    public ModelAndView getSpotDetails(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("spot_detail");
        Spot spot = spotDetailDataClient.getSpotById(id);
        List<Review> review=spotDetailDataClient.getSpotReviewById(id);
        modelAndView.addObject("spotInfo", spot);
        modelAndView.addObject("reviewInfo", review);
        return modelAndView;
    }
    @PostMapping("/submitSpotComment")
    public ResponseEntity<Boolean> submitComment(HttpServletRequest request,
                                                 @RequestParam("commentContent") String commentContent,
                                                 @RequestParam("spotId") Long spotId) {
        String username = null;
        String userAvatar = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                } else if ("userAvatar".equals(cookie.getName())) {
                    userAvatar = cookie.getValue();
                }
            }
        }

        // 创建新的评论对象并设置属性
        Review newComment = new Review();
        newComment.setUserName(username);
        newComment.setContent(commentContent);
        newComment.setReviewTime(Timestamp.valueOf(LocalDateTime.now()));
        newComment.setReviewType(0);
        newComment.setRelationId(spotId);
        newComment.setUserAvatar(userAvatar);

        // 保存评论到数据库
        return spotDetailDataClient.saveSpotComment(newComment);
    }
}
