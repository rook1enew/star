package com.test.demo.dao;

import com.test.demo.dto.UserModifyDto;
import com.test.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao {

    List<UserEntity> getByUserNameAndPwd(@Param(value = "userName") String userName, @Param(value = "pwd") String pwd);

    void addUser(UserEntity userEntity);

    UserEntity getByUserId(@Param(value = "userId") Long userId);

    void updateUser(UserModifyDto userModifyDto);

    List<UserEntity> getByUserName(@Param(value = "userName") String userName);

    List<UserEntity> getByUserPosition(@Param(value = "userPosition") String userPosition);

    List<UserEntity> getByMobileNum(@Param(value = "mobileNum") String mobileNum);

    long totalUser();

    List<UserEntity> userList(long offset, long limit);
}
