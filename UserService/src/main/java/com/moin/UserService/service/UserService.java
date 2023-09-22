package com.moin.UserService.service;

import com.moin.UserService.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity userDto) ;
    List<UserEntity> getAllUser();
    UserEntity getUserByUserId(String id) ;
}
