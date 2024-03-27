package io.gitee.felixzc.novel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.gitee.felixzc.novel.core.common.resp.RestResp;
import io.gitee.felixzc.novel.core.constant.DatabaseConsts;
import io.gitee.felixzc.novel.dao.entity.NewsContent;
import io.gitee.felixzc.novel.dao.entity.NewsInfo;
import io.gitee.felixzc.novel.dao.mapper.NewsContentMapper;
import io.gitee.felixzc.novel.dao.mapper.NewsInfoMapper;
import io.gitee.felixzc.novel.dto.resp.NewsInfoRespDto;
import io.gitee.felixzc.novel.manager.cache.NewsCacheManager;
import io.gitee.felixzc.novel.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 新闻模块 服务实现类
 */
@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsCacheManager newsCacheManager;

    private final NewsInfoMapper newsInfoMapper;

    private final NewsContentMapper newsContentMapper;

    @Override
    public RestResp<List<NewsInfoRespDto>> listLatestNews() {
        return RestResp.ok(newsCacheManager.listLatestNews());
    }

    @Override
    public RestResp<NewsInfoRespDto> getNews(Long id) {
        NewsInfo newsInfo = newsInfoMapper.selectById(id);
        QueryWrapper<NewsContent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.NewsContentTable.COLUMN_NEWS_ID, id)
            .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        NewsContent newsContent = newsContentMapper.selectOne(queryWrapper);
        return RestResp.ok(NewsInfoRespDto.builder()
                .title(newsInfo.getTitle())
                .sourceName(newsInfo.getSourceName())
                .updateTime(newsInfo.getUpdateTime())
                .content(newsContent.getContent())
                .build());
    }
}
