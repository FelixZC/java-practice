package io.gitee.felixzc.novel;

import io.gitee.felixzc.novel.core.constant.MessageSenderTypeConsts;
import io.gitee.felixzc.novel.manager.message.AbstractMessageSender;
import io.gitee.felixzc.novel.manager.message.MessageSender;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NovelApplication.class)
public class MessageSenderTest{

    @Autowired
    private Map<String, AbstractMessageSender> messageSenders;

    @Test
    public void test(){
        MessageSender registerMailSender = messageSenders.get(
                MessageSenderTypeConsts.REGISTER_MAIL_SENDER);
        if (Objects.nonNull(registerMailSender)) {
            registerMailSender.sendMessage(11111L, "xxyopen@foxmail.com", "xxyopen");
        }
        MessageSender seckillSysNoticeSender = messageSenders.get(
                MessageSenderTypeConsts.SECKILL_SYS_NOTICE_SENDER);
        if (Objects.nonNull(registerMailSender)) {
            seckillSysNoticeSender.sendMessage(11111L, "全场商品", "今晚 9 点", "www.xxyopen.com");
        }
    }

}
