package com.move.TripBalance.mypage.controller;

import com.move.TripBalance.mypage.controller.request.MyPageRequestDto;
import com.move.TripBalance.mypage.service.MyPageService;
import com.move.TripBalance.shared.exception.PrivateResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tb")
public class MyPageController {
    private final MyPageService myPageService;

    // 내 정보 확인
    @GetMapping("/mypage/info")
    public ResponseEntity<PrivateResponseBody> getMyInfo(HttpServletRequest request){
        return myPageService.myInfo(request);}

    // 내 정보 수정
    @PutMapping("/mypage/setinfo")
    public ResponseEntity<PrivateResponseBody> setMyInfo(@RequestBody MyPageRequestDto requestDto, HttpServletRequest request){
        return myPageService.setMyInfo(requestDto, request);}

    // 나의 밸런스 게임 선택지 통계
    @GetMapping("/mypage/balancedb")
    public ResponseEntity<PrivateResponseBody> getMyGame(HttpServletRequest request){
        return myPageService.myBalance(request);}

    // 나의 밸런스 게임 여행지 통계
    @GetMapping("/mypage/tripdb")
    public ResponseEntity<PrivateResponseBody> getMyTrip(HttpServletRequest request){
        return myPageService.myTrip(request);}

    // 내가 작성한 글 목록
    @GetMapping(value = "/mypage/posts/{page}")
    public ResponseEntity<PrivateResponseBody> getMyPosts(HttpServletRequest request, @PathVariable int page) {
        return myPageService.getMyPosts(request, page); }

    // 내가 좋아요한 글 목록
    @GetMapping(value = "/mypage/hearts/{page}")
    public ResponseEntity<PrivateResponseBody> getMyHearts(HttpServletRequest request, @PathVariable int page) {
        return myPageService.getMyHeartPosts(request, page); }

    // 회원의 개인정보 확인
    @GetMapping(value = "/memberinfo/{memberId}")
    public ResponseEntity<PrivateResponseBody> getMemberInfo(@PathVariable Long memberId){
        return myPageService.getMemberInfo(memberId); }

    // 회원의 밸런스 게임 선택지 통계
    @GetMapping(value = "/memberinfo/balancedb/{memberId}")
    public ResponseEntity<PrivateResponseBody> getMemberGame(@PathVariable Long memberId){
        return myPageService.getMemberBalance(memberId);
    }

    // 회원의 밸런스 게임 여행지 통계
    @GetMapping(value = "/memberinfo/tripdb/{memberId}")
    public ResponseEntity<PrivateResponseBody> getMemberTrip(@PathVariable Long memberId){
        return myPageService.getMemberTrip(memberId);
    }

    // 회원의 작성한 글 목록
    @GetMapping(value = "/memberinfo/posts/{memberId}/{page}")
    public ResponseEntity<PrivateResponseBody> getMemberPosts(@PathVariable Long memberId, @PathVariable int page){
        return myPageService.getMemberPosts(memberId, page);}

    // 회원의 좋아요한 글 목록
    @GetMapping(value = "/memberinfo/hearts/{memberId}/{page}")
    public ResponseEntity<PrivateResponseBody> getMemberHearts(@PathVariable Long memberId, @PathVariable int page){
        return myPageService.getMemberHeartPosts(memberId, page);}
}
