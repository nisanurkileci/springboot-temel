package com.archis.spring_bebka.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessagePrinter messagePrinter;

    public MessageService(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public void processMessage() {
        messagePrinter.printMessage();
    }
}
