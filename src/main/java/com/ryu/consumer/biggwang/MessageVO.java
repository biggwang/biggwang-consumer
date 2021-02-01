package com.ryu.consumer.biggwang;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MessageVO {

    @Builder.Default
    private String id = "";

    @Builder.Default
    private String text = "";

    @Builder.Default
    private Long delayTime = 0L;
}
