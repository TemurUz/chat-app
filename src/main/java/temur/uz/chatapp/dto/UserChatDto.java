package temur.uz.chatapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserChatDto {
    private Long userId;
    private String username;
    private Date createAt;
    private List<ChatDto> chats;
}
