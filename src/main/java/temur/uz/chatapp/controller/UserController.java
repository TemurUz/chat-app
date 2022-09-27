package temur.uz.chatapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import temur.uz.chatapp.dto.UserDto;
import temur.uz.chatapp.model.Result;
import temur.uz.chatapp.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    //service
    private final UserServiceImpl userService;

    @PostMapping("/save")
    public ResponseEntity<Result> save(@RequestBody UserDto dto){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(userService.addNewUser(dto));
    }

}
