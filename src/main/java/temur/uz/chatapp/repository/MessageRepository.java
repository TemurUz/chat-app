package temur.uz.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import temur.uz.chatapp.dto.ChatMessageDto;
import temur.uz.chatapp.entity.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("select new temur.uz.chatapp.dto.ChatMessageDto(" +
            "m.chat.id, m.chat.name, m.author.id, m.author.username," +
            "m.text) from Message m where m.chat.id =?1 order by m.created_at")
    List<ChatMessageDto> findAllMessagesByChatId(Long chat_id);

}
