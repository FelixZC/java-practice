package io.gitee.felixzc.novel.controller.front;

import io.gitee.felixzc.novel.core.common.resp.RestResp;
import io.gitee.felixzc.novel.dto.resp.HomeBookRespDto;
import io.gitee.felixzc.novel.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.gitee.felixzc.novel.core.constant.ApiRouterConsts;

import java.util.List;

/**
 * 首页模块 API 接口
 */
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_HOME_URL_PREFIX)
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    /**
     * 首页小说推荐查询接口
     */
    @GetMapping("books")
    public RestResp<List<HomeBookRespDto>> listHomeBooks(){
        return homeService.listHomeBooks();
    }
}
