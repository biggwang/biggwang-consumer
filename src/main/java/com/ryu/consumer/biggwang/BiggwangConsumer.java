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

    @SqsListener(value = "yungwang.fifo", deletionPolicy = SqsMessageDeletionPolicy.ALWAYS)
    public void consume(String json) throws JsonProcessingException {
        MessageVO messageVO = objectMapper.readValue(json, MessageVO.class);
        log.info("### messageVO:{}", messageVO.toString());
    }
}
