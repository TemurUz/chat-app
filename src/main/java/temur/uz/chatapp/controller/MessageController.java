package temur.uz.chatapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import temur.uz.chatapp.dto.ChatMessageDto;
import temur.uz.chatapp.dto.MessageDto;
import temur.uz.chatapp.service.MessageService;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/save")
    public ChatMessageDto sendChatMessage(@RequestBody MessageDto dto) {
        return messageService.sendChatMessageBehalfUser(dto);
    }

    @GetMapping("/{chat_id}")
    public ResponseEntity<?> getListChat(@PathVariable Long chat_id) {
        return ResponseEntity.ok(messageService
                .getListMessageInSpecificChat(
                        chat_id
                )
        );
    }

    @GetMapping("/list/{chat_id}")
    public ResponseEntity<?> messageList(@PathVariable Long chat_id) {
        return ResponseEntity.ok(messageService
                .getListMessageInSpecificChat(chat_id));
    }

}
