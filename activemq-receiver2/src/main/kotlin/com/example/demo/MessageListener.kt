package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import java.io.Serializable

@Component
class MessageListener {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @JmsListener(destination = "VirtualTopicConsumers.server1.TOPIC.ORDER")
    fun listen(message: OrderMessage) {
        logger.info("Consumer Listen - > $message")
    }
}

data class OrderMessage(
        val payload: String = ""
) : Serializable