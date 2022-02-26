package temur.uz.chatapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import temur.uz.chatapp.dto.ChatMessageDto;
import temur.uz.chatapp.entity.Message;

@Mapper(componentModel = "spring")
public interface MessageMapper  {
    @Mappings({
            @Mapping(target = "chatId", source = "chat.id"),
            @Mapping(target = "chatName", source = "chat.name"),
            @Mapping(target = "userId", source = "author.id"),
            @Mapping(target = "userName", source = "author.username")
    })
    ChatMessageDto messageDto(Message message);
}
