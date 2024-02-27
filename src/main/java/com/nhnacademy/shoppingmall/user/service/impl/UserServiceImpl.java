package com.nhnacademy.shoppingmall.user.service.impl;

import com.nhnacademy.shoppingmall.user.exception.UserAlreadyExistsException;
import com.nhnacademy.shoppingmall.user.exception.UserNotFoundException;
import com.nhnacademy.shoppingmall.user.service.UserService;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.repository.UserRepository;

import java.rmi.AlreadyBoundException;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String userId) {

        //todo#4-1 회원조회
        userRepository.updateLatestLoginAtByUserId(userId, LocalDateTime.now());

        Optional<User> byId = userRepository.findById(userId);
        if (byId.isPresent()) {
            return byId.get();

        }else{
            return null;

        }



    }

    @Override
    public void saveUser(User user) {
        //todo#4-2 회원등록
        if (userRepository.countByUserId(user.getUserId()) != 1) {
            int save = userRepository.save(user);

            if (save != 1) {
                throw new RuntimeException("user not saved");
            }
        }else{
            throw new UserAlreadyExistsException(user.getUserId());
        }


    }

    @Override
    public void updateUser(User user) {
        //todo#4-3 회원수정
        if (userRepository.countByUserId(user.getUserId()) == 1) {
            int update = userRepository.update(user);
            if (update != 1) {
                throw new RuntimeException("user not updated");
            }
        }else{
            throw new RuntimeException("user is not exist");
        }

    }

    @Override
    public void deleteUser(String userId) {
        //todo#4-4 회원삭제
        if (userRepository.countByUserId(userId) == 1) {
            int result = userRepository.deleteByUserId(userId);
            if (result != 1) {
                throw new RuntimeException("user not deleted");
            }
        }

    }

    @Override
    public User doLogin(String userId, String userPassword) {
        //todo#4-5 로그인 구현, userId, userPassword로 일치하는 회원 조회
        Optional<User> optionalUser = userRepository.findByUserIdAndUserPassword(userId, userPassword);

        if (optionalUser.isPresent()) {
            int result = userRepository.updateLatestLoginAtByUserId(userId, LocalDateTime.now());
            return optionalUser.get();


        } else {
            throw new UserNotFoundException(userId);
        }



    }


}
