package temur.uz.chatapp.service;

import temur.uz.chatapp.dto.ChatDto;
import temur.uz.chatapp.dto.UserChatDto;
import temur.uz.chatapp.model.Result;

import java.util.List;
//2 Создать новый чат между пользователями-Foydalanuvchilar o'rtasida yangi chat yarating
public interface ChatService {
    /**
     *yangi chat qushish uchun metod
     */
    Result createNewChatBetweenUsers(ChatDto dto);

    /**
     *chatga user qushish uchun metod
     */
    Result addNewPersonToTheChat(Long chatId, List<Long> userId);

    UserChatDto getChatsOfUser(Long userId);
}
