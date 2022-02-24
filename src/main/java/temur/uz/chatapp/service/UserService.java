package temur.uz.chatapp.service;

import temur.uz.chatapp.model.Result;
import temur.uz.chatapp.dto.UserDto;

public interface UserService {
    //1 Добавить нового пользователя
    Result addNewUser(UserDto dto);
}
