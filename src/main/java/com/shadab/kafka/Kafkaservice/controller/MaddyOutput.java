package com.shadab.kafka.Kafkaservice.controller;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

public interface MaddyOutput {

    /**
     * Name of the output channel.
     */
    String OUTPUT = "maddyoutput";

    /**
     * @return output channel
     */
    @Output(MaddyOutput.OUTPUT)
    MessageChannel output();
}
