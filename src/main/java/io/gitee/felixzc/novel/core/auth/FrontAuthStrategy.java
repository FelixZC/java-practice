package io.gitee.felixzc.novel.core.auth;

import io.gitee.felixzc.novel.core.common.exception.BusinessException;
import io.gitee.felixzc.novel.core.util.JwtUtils;
import io.gitee.felixzc.novel.manager.cache.UserInfoCacheManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 前台门户系统 认证授权策略
 */
@Component
@RequiredArgsConstructor
public class FrontAuthStrategy implements AuthStrategy {

    private final JwtUtils jwtUtils;

    private final UserInfoCacheManager userInfoCacheManager;

    @Override
    public void auth(String token, String requestUri) throws BusinessException {
        // 统一账号认证
        authSSO(jwtUtils, userInfoCacheManager, token);
    }

}
