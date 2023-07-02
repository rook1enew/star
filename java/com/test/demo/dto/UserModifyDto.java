package com.test.demo.dto;

public class UserModifyDto extends UserRegisterDto {

    /**
     * 用户ID
     */
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
