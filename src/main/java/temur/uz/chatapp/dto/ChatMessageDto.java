package temur.uz.chatapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDto {
    private Long chatId;
    private String chatName;
    private Long userId;
    private String userName;
    private String text;
}
