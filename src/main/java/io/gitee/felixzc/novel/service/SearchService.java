package io.gitee.felixzc.novel.service;

import io.gitee.felixzc.novel.core.common.resp.PageRespDto;
import io.gitee.felixzc.novel.core.common.resp.RestResp;
import io.gitee.felixzc.novel.dto.req.BookSearchReqDto;
import io.gitee.felixzc.novel.dto.resp.BookInfoRespDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * 搜索 服务类
 */
public interface SearchService {

    /**
     * 小说搜索
     *
     * @param condition 搜索条件
     * @return 搜索结果
     */
    RestResp<PageRespDto<BookInfoRespDto>> searchBooks(BookSearchReqDto condition);
}
