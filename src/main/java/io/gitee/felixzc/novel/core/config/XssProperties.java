package io.gitee.felixzc.novel.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Xss 过滤配置属性
 */
@ConfigurationProperties(prefix = "novel.xss")
public record XssProperties(Boolean enabled, List<String> excludes) {

}
