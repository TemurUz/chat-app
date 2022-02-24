package temur.uz.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import temur.uz.chatapp.entity.Users;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByIdIn(Collection<Long> id);

    boolean existsByUsername(String username);

}
