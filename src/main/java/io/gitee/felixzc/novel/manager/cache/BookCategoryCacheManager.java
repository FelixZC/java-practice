package io.gitee.felixzc.novel.manager.cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.gitee.felixzc.novel.core.constant.CacheConsts;
import io.gitee.felixzc.novel.core.constant.DatabaseConsts;
import io.gitee.felixzc.novel.dao.entity.BookCategory;
import io.gitee.felixzc.novel.dao.mapper.BookCategoryMapper;
import io.gitee.felixzc.novel.dto.resp.BookCategoryRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 小说分类 缓存管理类
 */
@Component
@RequiredArgsConstructor
public class BookCategoryCacheManager {

    private final BookCategoryMapper bookCategoryMapper;

    /**
     * 根据作品方向查询小说分类列表，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER,
            value = CacheConsts.BOOK_CATEGORY_LIST_CACHE_NAME)
    public List<BookCategoryRespDto> listCategory(Integer workDirection) {
        QueryWrapper<BookCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.BookCategoryTable.COLUMN_WORK_DIRECTION, workDirection);
        return bookCategoryMapper.selectList(queryWrapper).stream().map(v ->
                BookCategoryRespDto.builder()
                        .id(v.getId())
                        .name(v.getName())
                        .build()).toList();
    }

}
