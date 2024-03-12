package com.tistesoa.infrastructure;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

   StreamBridge streamBridge;

   public MessageProducer(StreamBridge sb){
      this.streamBridge = sb;
   }
   public void sendMessage(String message){
      streamBridge.send("toStream-in-0",message);
   }
}
