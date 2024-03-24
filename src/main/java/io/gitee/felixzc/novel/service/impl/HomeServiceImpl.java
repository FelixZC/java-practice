package io.gitee.felixzc.novel.service.impl;

import io.gitee.felixzc.novel.core.common.resp.RestResp;
import io.gitee.felixzc.novel.dto.resp.HomeBookRespDto;
import io.gitee.felixzc.novel.manager.cache.HomeBookCacheManager;
import io.gitee.felixzc.novel.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页模块 服务实现类
 */
@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final HomeBookCacheManager homeBookCacheManager;

    @Override
    public RestResp<List<HomeBookRespDto>> listHomeBooks() {
        return RestResp.ok(homeBookCacheManager.listHomeBooks());
    }
}
