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
    public void consume(String json) throws JsonProcessingException, InterruptedException {
        MessageVO messageVO = objectMapper.readValue(json, MessageVO.class);
        log.info("### 메시지 처리 시작 ------------------------------------------------------> ");
        log.info("### 메시지 내용:{}", messageVO.toString());
//        Thread.sleep(messageVO.getDelayTime());
        log.info("### 메시지 처리 종료 <------------------------------------------------------");
        log.info("");
    }
}
