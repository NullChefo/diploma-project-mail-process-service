package com.nullchefo.mailservice.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nullchefo.mailservice.entity.Mail;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MailProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MailProducer.class);
	@Value("${mail.send.exchange}")
	private String exchange;
	@Value("${mail.routing.key}")
	private String routingKey;
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMail(Mail mail) { // sends it to mail-send-service with mail-send-excahnge
		LOGGER.info(String.format("Mail-send-service send message -> %s", mail.toString()));

		rabbitTemplate.convertAndSend(exchange, routingKey, mail);
	}
}
