package temur.uz.chatapp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import temur.uz.chatapp.entity.Users;
import temur.uz.chatapp.exceptions.UserDataFailedIsNotSavedException;
import temur.uz.chatapp.model.Result;
import temur.uz.chatapp.dto.UserDto;
import temur.uz.chatapp.repository.UserRepository;
import temur.uz.chatapp.service.UserService;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    //repository
    private final UserRepository userRepository;

    @Override
    public Result addNewUser(UserDto dto) {
        try {
            Users users = new Users();
            boolean b = userRepository.existsByUsername(dto.getUsername());
            if (b){
                users.setUsername(dto.getUsername());
                userRepository.save(users);
                return new Result(true, "user successfully saved");
            }else {
                return new Result(false, "this is user has already add");
            }
        }catch (Exception e){
            log.error(e.getMessage() + " user data failed not saved");
            throw  new UserDataFailedIsNotSavedException();
        }
    }

}
