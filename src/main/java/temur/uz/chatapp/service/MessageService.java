package temur.uz.chatapp.service;

import temur.uz.chatapp.dto.ChatMessageDto;
import temur.uz.chatapp.dto.MessageDto;
import temur.uz.chatapp.entity.Message;

import java.util.List;

public interface MessageService {
    //3 Отправить сообщение в чат от лица пользователя-Foydalanuvchi nomidan chat xabarini yuboring
    ChatMessageDto sendChatMessageBehalfUser(MessageDto dto);
    //5 Получить список сообщений в конкретном чате - Muayyan chatdagi xabarlar ro'yxatini oling
    List<ChatMessageDto> getListMessageInSpecificChat(Long chat_id);
}
