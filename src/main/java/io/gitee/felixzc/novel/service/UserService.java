package io.gitee.felixzc.novel.service;

import io.gitee.felixzc.novel.core.common.resp.RestResp;
import io.gitee.felixzc.novel.dto.req.UserLoginReqDto;
import io.gitee.felixzc.novel.dto.req.UserRegisterReqDto;
import io.gitee.felixzc.novel.dto.resp.UserLoginRespDto;
import io.gitee.felixzc.novel.dto.resp.UserRegisterRespDto;

public interface UserService {
    /**
     * 用户注册
     *
     * @param dto 注册参数
     * @return JWT
     */
    RestResp<UserRegisterRespDto> register(UserRegisterReqDto dto);

    /**
     * 用户登录
     *
     * @param dto 登录参数
     * @return JWT + 昵称
     */
    RestResp<UserLoginRespDto> login(UserLoginReqDto dto);
}
