package com.example.crud_1.controller;

import com.example.crud_1.dto.UserDTO;
import com.example.crud_1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * insertUser : 생성 (Post)
     * getAllUsers : 모든 유저 조회 (Get)
     * getUserByUserId : 해당 유저 조회 (Get)
     * updateUser : 해당 유저 수정 (Put)
     * deleteUser : 해당 유저 삭제 (Delete)
     */

    // @RequestBody 는 객체를 Json 형태로 받기 위하여 사용하는 어노테이션
    @PostMapping("/")
    public UserDTO insertUser(@RequestBody UserDTO user) {
        return userService.insertUser(user);
    }

    @GetMapping("/")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public void updateUserPw(@PathVariable String userId, @RequestBody UserDTO user) {
        userService.updateUserPw(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}
