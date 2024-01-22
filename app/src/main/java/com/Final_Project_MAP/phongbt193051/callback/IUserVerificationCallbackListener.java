package com.Final_Project_MAP.phongbt193051.callback;

import com.Final_Project_MAP.phongbt193051.model.User;

import java.util.List;

public interface IUserVerificationCallbackListener {
    void onGradeLoadSuccess(List<User> users);
    void onGradeLoadFailed(String message);
}
