package com.example.controller;

import com.example.client.HotelDetailDataClient;
import com.example.model.Hotel;
import com.example.model.Review;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HotelDetailController {
    @Autowired
    private HotelDetailDataClient hotelDetailDataClient;
    @GetMapping("/hotelDetail")
    public ModelAndView  getHotelDetails(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("hotel_detail");
        Hotel hotel = hotelDetailDataClient.getHotelById(id);
        List<Review> review=hotelDetailDataClient.getReviewById(id);
        modelAndView.addObject("hotelInfo", hotel);
        modelAndView.addObject("reviewInfo", review);
        return modelAndView;
    }
    @PostMapping("/submitComment")
    public ResponseEntity<Boolean> submitComment(HttpServletRequest request,
                                                 @RequestParam("commentContent") String commentContent,
                                                 @RequestParam("hotelId") Long hotelId) {
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
        newComment.setReviewType(1);
        newComment.setRelationId(hotelId);
        newComment.setUserAvatar(userAvatar);

        // 保存评论到数据库
        return hotelDetailDataClient.saveComment(newComment);
    }

}
