package com.Final_Project_MAP.phongbt193051.callback;

import com.Final_Project_MAP.phongbt193051.model.Class_Names;

import java.util.List;

public interface IMainActivityCallbackListener {
    void onGradeLoadSuccess(List<Class_Names> class_names);
    void onGradeLoadFailed(String message);
}
