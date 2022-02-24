package temur.uz.chatapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {
    private String name;
    private Long id;
    private Date  createAt;
    public ChatDto(String name){
        this.name = name;
    }
}
