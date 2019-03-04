package org.jboss.aesh.nanook;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;

public class WebSocketHandler extends AbstractWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("Running " + message + " command...");
        AeshWrapper aeshWrapper = new AeshWrapper();
        String result = aeshWrapper.run(message.getPayload());
        TextMessage tmr = new TextMessage(result);
        session.sendMessage(tmr);
    }

}
