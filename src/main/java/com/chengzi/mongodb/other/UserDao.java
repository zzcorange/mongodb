package com.chengzi.mongodb.other;

public interface UserDao {
    void saveUser(UserEntity user);

    UserEntity findUserByUserName(String userName);

    void updateUser(UserEntity user);

    void deleteUserById(Long id);
}
