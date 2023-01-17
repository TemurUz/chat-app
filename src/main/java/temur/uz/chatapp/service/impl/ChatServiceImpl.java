package temur.uz.chatapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import temur.uz.chatapp.dto.ChatDto;
import temur.uz.chatapp.dto.UserChatDto;
import temur.uz.chatapp.entity.Chat;
import temur.uz.chatapp.entity.Users;
import temur.uz.chatapp.exceptions.NotFoundException;
import temur.uz.chatapp.exceptions.UserDataFailedIsNotSavedException;
import temur.uz.chatapp.exceptions.UserNotFoundException;
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
            throw new RuntimeException("New chat doesn't creat between users");
        }
    }

    @Override
    public Result addNewPersonToTheChat(Long chatId, List<Long> userIds) {
        try {
            List<Users> users = userRepository.findAllByIdIn(userIds);
            if (users.isEmpty()) {
                throw new NotFoundException();
            }
            Chat chat = chatRepository.findById(chatId).orElseThrow(NotFoundException::new);
            chat.setUsers(users);
            chatRepository.save(chat);
            return new Result(true, "new people add");
        } catch (UserDataFailedIsNotSavedException e) {
            throw new UserDataFailedIsNotSavedException();
        }
    }

    @Override
    public UserChatDto getChatsOfUser(Long userId) {
        Optional<Users> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            UserChatDto chatDto = new UserChatDto();
            chatDto.accept(optionalUser.get());
            chatDto.setChats(chatRepository.getChatsByUserId(userId));
            return chatDto;
        }
        throw new UserNotFoundException();
    }

}
