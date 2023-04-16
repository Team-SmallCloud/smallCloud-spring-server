package cap.stone.team.smallCloud.chat;

import cap.stone.team.smallCloud.data.dto.ChatMessage;
import cap.stone.team.smallCloud.data.dto.ChatRoom;
import cap.stone.team.smallCloud.service.chat.ChatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected  void handleTextMessage(WebSocketSession socketSession, TextMessage textMessage) throws JsonProcessingException {
        String payload = textMessage.getPayload();
        log.info("{}", payload);
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);

        ChatRoom chatRoom = chatService.findRoomById(chatMessage.getRoomId());
        chatRoom.handlerActions(socketSession, chatMessage, chatService);
    }
}
