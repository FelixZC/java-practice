package io.gitee.felixzc.novel.service;

import io.gitee.felixzc.novel.core.common.resp.RestResp;
import io.gitee.felixzc.novel.dto.resp.HomeBookRespDto;

import java.util.List;

/**
 * 首页模块 服务类
 */
public interface HomeService {
    /**
     * 查询首页小说推荐列表
     *
     * @return 首页小说推荐列表的 rest 响应结果
     */
    RestResp<List<HomeBookRespDto>> listHomeBooks();
}