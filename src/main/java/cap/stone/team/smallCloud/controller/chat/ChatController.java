package cap.stone.team.smallCloud.controller.chat;

import cap.stone.team.smallCloud.data.dto.ChatRoom;
import cap.stone.team.smallCloud.service.chat.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat")
@RestController
public class ChatController {
    private final ChatService chatService;

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        List<ChatRoom> allRoom = chatService.findAllRoom();
        log.info("test");
        log.info("{}", allRoom.get(0).getName());
        log.info("{}", allRoom.get(0).getRoomId());
        log.info("{}", allRoom.get(0).getSessions());
        return allRoom;
    }

    @PostMapping
    public ChatRoom createRoom(@RequestBody String name) {
        return chatService.createRoom(name);
    }
}
