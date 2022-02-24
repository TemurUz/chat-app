package temur.uz.chatapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import temur.uz.chatapp.dto.ChatDto;
import temur.uz.chatapp.dto.UserList;
import temur.uz.chatapp.model.Result;
import temur.uz.chatapp.repository.ChatRepository;
import temur.uz.chatapp.service.ChatService;

@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/save")
    public ResponseEntity<?> newChatAdd(@RequestBody ChatDto dto) {
        Result newChatBetweenUsers = chatService.createNewChatBetweenUsers(dto);
        if (newChatBetweenUsers.getSuccess()) {
            return ResponseEntity.ok(newChatBetweenUsers);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newChatBetweenUsers);
    }

    @PutMapping("/{chat_id}")
    public ResponseEntity<?> newUsersChatToAdd(@PathVariable Long chat_id, @RequestBody UserList userList) {
        Result result = chatService.addNewPersonToTheChat(chat_id, userList.getUsers_id());
        if (result.getSuccess())
            return ResponseEntity.ok(result);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<?> getChat(@PathVariable Long userid){
        return ResponseEntity.ok(chatService.getChatsOfUser(userid));
    }

}
