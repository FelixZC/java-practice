package io.gitee.felixzc.novel.service;

import io.gitee.felixzc.novel.core.common.resp.RestResp;
import io.gitee.felixzc.novel.dto.resp.ImgVerifyCodeRespDto;

import java.io.IOException;

public interface ResourceService {
    RestResp<ImgVerifyCodeRespDto> getImgVerifyCode() throws IOException;
}
