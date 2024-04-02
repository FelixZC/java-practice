package io.gitee.felixzc.novel.core.listener;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import io.gitee.felixzc.novel.core.constant.AmqpConsts;
import io.gitee.felixzc.novel.core.constant.EsConsts;
import io.gitee.felixzc.novel.dao.entity.BookInfo;
import io.gitee.felixzc.novel.dao.mapper.BookInfoMapper;
import io.gitee.felixzc.novel.dto.es.EsBookDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Rabbit 队列监听器
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitQueueListener {

    private final BookInfoMapper bookInfoMapper;

    private final ElasticsearchClient esClient;

    /**
     * 监听小说信息改变的 ES 更新队列，更新最新小说信息到 ES
     * */
    @RabbitListener(queues = AmqpConsts.BookChangeMq.QUEUE_ES_UPDATE)
    @SneakyThrows
    public void updateEsBook(Long bookId) {
        BookInfo bookInfo = bookInfoMapper.selectById(bookId);
        IndexResponse response = esClient.index(i -> i
                .index(EsConsts.BookIndex.INDEX_NAME)
                .id(bookInfo.getId().toString())
                .document(EsBookDto.build(bookInfo))
        );
        log.info("Indexed with version " + response.version());
    }

    // ... 监听其它队列，刷新其它副本数据

}
