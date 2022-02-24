package temur.uz.chatapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import temur.uz.chatapp.dto.ChatDto;
import temur.uz.chatapp.dto.UserChatDto;
import temur.uz.chatapp.entity.Chat;
import temur.uz.chatapp.entity.Users;
import temur.uz.chatapp.exceptions.NotFoundException;
import temur.uz.chatapp.model.Result;
import temur.uz.chatapp.repository.ChatRepository;
import temur.uz.chatapp.repository.UserRepository;
import temur.uz.chatapp.service.ChatService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    //repository
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    @Override
    public Result createNewChatBetweenUsers(ChatDto dto) {
        try {
            Chat chat = new Chat();
            chat.setName(dto.getName());
            chatRepository.save(chat);
            return new Result(true, "is a new chat to created");
        } catch (Exception e) {
            return new Result(false, "failed");
        }
    }

    @Override
    public Result addNewPersonToTheChat(Long chatId, List<Long> userIds) {
        try {
            Chat chat = chatRepository.findById(chatId).orElseThrow(NotFoundException::new);
            List<Users> users = userRepository.findAllByIdIn(userIds);
            if (users.isEmpty()) {
                throw new NotFoundException();
            }
            chat.setUsers(users);
            chatRepository.save(chat);
            return new Result(true, "new people add");
        } catch (Exception e) {
            return new Result(false, "Error!");
        }
    }

    @Override
    public UserChatDto getChatsOfUser(Long userId) {
        Optional<Users> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()){
            UserChatDto chatDto = new UserChatDto();
            chatDto.setUserId(userId);
            chatDto.setUsername(optionalUser.get().getUsername());
            chatDto.setCreateAt(optionalUser.get().getCreated_at());
            chatDto.setChats(chatRepository.getChatsByUserId(userId));
            return chatDto;
        }else {
            return new UserChatDto();
        }
    }

}
