package com.test.demo.service;

import com.test.demo.dao.UserDao;
import com.test.demo.dto.UserModifyDto;
import com.test.demo.dto.UserRegisterDto;
import com.test.demo.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public UserEntity getByUserNameAndPwd(String userName, String pwd) {
        List<UserEntity> userList = userDao.getByUserNameAndPwd(userName, pwd);
        if (CollectionUtils.isEmpty(userList)) {
           return null;
        }
        return userList.get(0);
    }

    public UserEntity getByUserPosition(String userPosition) {
        List<UserEntity> userList = userDao.getByUserPosition(userPosition);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }

    public void addUser(UserRegisterDto userRegisterDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRegisterDto, userEntity);
//        userEntity.setUserName(userRegisterDto.getUserName());
        userDao.addUser(userEntity);
    }

    public UserEntity getByUserId(Long userId) {
        return userDao.getByUserId(userId);
    }

    public void updateUser(UserModifyDto userModifyDto) {
        userDao.updateUser(userModifyDto);
    }

    public List<UserEntity> getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }

    public List<UserEntity> getByMobileNum(String mobileNum) {
        return userDao.getByMobileNum(mobileNum);
    }

    public long totalUser() {
        return userDao.totalUser();
    }

    public List<UserEntity> userList(long pageNum, long limit) {
        long offset = (pageNum - 1) * limit;
        return userDao.userList(offset, limit);
    }
}
