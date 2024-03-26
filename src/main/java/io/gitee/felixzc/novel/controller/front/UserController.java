package io.gitee.felixzc.novel.controller.front;

import io.gitee.felixzc.novel.core.auth.UserHolder;
import io.gitee.felixzc.novel.core.common.resp.RestResp;
import io.gitee.felixzc.novel.core.constant.ApiRouterConsts;
import io.gitee.felixzc.novel.core.constant.SystemConfigConsts;
import io.gitee.felixzc.novel.dto.req.UserCommentReqDto;
import io.gitee.felixzc.novel.dto.req.UserLoginReqDto;
import io.gitee.felixzc.novel.dto.req.UserRegisterReqDto;
import io.gitee.felixzc.novel.dto.resp.BookCommentRespDto;
import io.gitee.felixzc.novel.dto.resp.UserLoginRespDto;
import io.gitee.felixzc.novel.dto.resp.UserRegisterRespDto;
import io.gitee.felixzc.novel.service.BookService;
import io.gitee.felixzc.novel.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "UserController", description = "前台门户-会员模块")
@SecurityRequirement(name = SystemConfigConsts.HTTP_AUTH_HEADER_NAME)
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_USER_URL_PREFIX)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final BookService bookService;
    /**
     * 用户注册接口
     */
    @PostMapping("/register")
    public RestResp<UserRegisterRespDto> register(@Valid @RequestBody UserRegisterReqDto dto) {
        return userService.register(dto);
    }

    /**
     * 用户登录接口
     */
    @PostMapping("/login")
    public RestResp<UserLoginRespDto> login(@Valid @RequestBody UserLoginReqDto dto) {
        return userService.login(dto);
    }

    /**
     * 发表评论接口
     */
    @PostMapping("/comment")
    public RestResp<Void> comment(@Valid @RequestBody UserCommentReqDto dto) {
        dto.setUserId(UserHolder.getUserId());
        return bookService.saveComment(dto);
    }

    /**
     * 修改评论接口
     */
    @PutMapping("/comment/{id}")
    public RestResp<Void> updateComment(@PathVariable Long id, String content) {
        return bookService.updateComment(UserHolder.getUserId(), id, content);
    }

    /**
     * 删除评论接口
     */
    @DeleteMapping("/comment/{id}")
    public RestResp<Void> deleteComment(@PathVariable Long id) {
        return bookService.deleteComment(UserHolder.getUserId(), id);
    }

    /**
     * 小说最新评论查询接口
     */
    @GetMapping("/comment/newest_list")
    public RestResp<BookCommentRespDto> listNewestComments(Long bookId) {
        return bookService.listNewestComments(bookId);
    }


}

