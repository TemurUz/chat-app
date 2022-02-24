package temur.uz.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import temur.uz.chatapp.dto.ChatDto;
import temur.uz.chatapp.entity.Chat;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    @Query("select new temur.uz.chatapp.dto.ChatDto(ch.name,ch.id, ch.created_at) from Chat ch join ch.users us on us.id=?1")
    List<ChatDto> getChatsByUserId(Long userId);
}
