package temur.uz.chatapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import temur.uz.chatapp.dto.ChatMessageDto;
import temur.uz.chatapp.dto.MessageDto;
import temur.uz.chatapp.entity.Chat;
import temur.uz.chatapp.entity.Message;
import temur.uz.chatapp.entity.Users;
import temur.uz.chatapp.exceptions.NotFoundException;
import temur.uz.chatapp.exceptions.UserNotFoundException;
import temur.uz.chatapp.repository.ChatRepository;
import temur.uz.chatapp.repository.MessageRepository;
import temur.uz.chatapp.repository.UserRepository;
import temur.uz.chatapp.service.MessageService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    //repository
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    @Override
    public ChatMessageDto sendChatMessageBehalfUser(MessageDto dto) {
        Chat chat = chatRepository.findById(dto.getChatId()).orElseThrow(NotFoundException::new);
        Message message = new Message();
        message.setChat(chat);
        Users users = userRepository.findById(dto.getAuthorId()).orElseThrow(UserNotFoundException::new);
        message.setAuthor(users);
        message.setText(dto.getText());
        return parse(messageRepository.save(message));
    }

    @Override
    public List<ChatMessageDto> getListMessageInSpecificChat(Long chat_id) {
        try {
            return messageRepository.findAllMessagesByChatId(chat_id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ChatMessageDto parse(Message message) {
        ChatMessageDto chatMessageDto = new ChatMessageDto();
        chatMessageDto.setText(message.getText());
        chatMessageDto.setChatId(message.getChat().getId());
        chatMessageDto.setChatName(message.getChat().getName());
        chatMessageDto.setUserId(message.getAuthor().getId());
        chatMessageDto.setUserName(message.getAuthor().getUsername());
        return chatMessageDto;
    }
}
