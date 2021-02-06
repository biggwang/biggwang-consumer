package com.ryu.consumer.biggwang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BiggwangConsumer {

    private final ObjectMapper objectMapper;

    @SqsListener(value = "yungwang.fifo", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void consume(String json) throws Exception {
        MessageVO messageVO = objectMapper.readValue(json, MessageVO.class);
        log.info("");
        log.info("### 메시지 처리 시작:{}", messageVO.toString());
        Thread.sleep(messageVO.getDelayTime());
        if (messageVO.isError()) {
            log.info("### 에러 발생 !!");
            throw new Exception("error");
        }

        log.info("### 메시지 처리 종료");
    }
}
