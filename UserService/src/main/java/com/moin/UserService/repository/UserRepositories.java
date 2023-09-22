package com.moin.UserService.repository;

import com.moin.UserService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<UserEntity, String> {

}
