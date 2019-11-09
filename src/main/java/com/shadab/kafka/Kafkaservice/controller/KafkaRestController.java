package com.shadab.kafka.Kafkaservice.controller;


import com.shadab.kafka.Kafkaservice.request.RequestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@EnableBinding({Source.class, MaddyOutput.class})
public class KafkaRestController {


    @Autowired
    Source source;
    @Autowired
    MaddyOutput maddyOutput;

   //////@Autowired
    ///MessageChannel messageChannel;

    @PostMapping(value = "/publish",consumes = "application/json")

    public String publishTokafka(@RequestBody RequestDetails requestDetails) throws Exception{


        //String s = new String(payloadJson.getBytes("UTF-8"),"UTF-8");

        String count = requestDetails.getStatus_count();
        MessageChannel messageChannel = source.output();
        messageChannel.send(MessageBuilder.withPayload(count).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
        return "shadab";
    }


    @PostMapping(value = "/publish1",consumes = "application/json")

    public String publishTokafka1(@RequestBody  String payloadJson) throws Exception{


        String s = new String(payloadJson.getBytes("UTF-8"),"UTF-8");
        MessageChannel messageChannel = maddyOutput.output();
        messageChannel.send(MessageBuilder.withPayload(payloadJson).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
        return "shadab";
    }



}
