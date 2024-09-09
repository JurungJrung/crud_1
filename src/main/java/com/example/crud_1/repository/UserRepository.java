package com.example.crud_1.repository;

import com.example.crud_1.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    // db 연동 코드
    // JPA
    static public ArrayList<UserDTO> users;

    static {
        users = new ArrayList<>();
        users.add(new UserDTO("kang","test1","1234"));
        users.add(new UserDTO("park","test2","1234"));
        users.add(new UserDTO("kim","test3","1234"));
    }
    // 생성
    public UserDTO insertUser(UserDTO user) {
        users.add(user);
        return user;
    }
    // 전체 리스트 조회
    public List<UserDTO> getAllUsers(){
        return users;
    }
    // 특정 아이디 조회 (단건 조회)
    public UserDTO getUserById(String userId) {
        return users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("","",""));
    }
    // Pw 수정
    public void updateUserPw(String userId, UserDTO user) {
        users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("","",""))
                .setUserPw(user.getUserPw());
    }
    // 삭제
    public void deleteUser(String userId) {
        users.removeIf(userDTO -> userDTO.getUserId().equals(userId));
    }

}
