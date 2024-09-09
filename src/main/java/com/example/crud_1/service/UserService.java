package com.example.crud_1.service;

import com.example.crud_1.dto.UserDTO;
import com.example.crud_1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * insertUser : 생성
     * getAllUsers : 모든 유저 조회
     * getUserByUserId : 해당 유저 조회
     * updateUser : 해당 유저 수정
     * deleteUser : 해당 유저 삭제
     */

    public UserDTO insertUser(UserDTO user) {
        return userRepository.insertUser(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserDTO getUserById(String userId) {
        return userRepository.getUserById(userId);
    }

    public void updateUserPw(String userId, UserDTO user) {
        userRepository.updateUserPw(userId,user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }

}
