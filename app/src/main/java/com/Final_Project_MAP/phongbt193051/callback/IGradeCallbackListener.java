package com.Final_Project_MAP.phongbt193051.callback;

import com.Final_Project_MAP.phongbt193051.model.Grade_Names;

import java.util.List;

public interface IGradeCallbackListener {
    void onGradeLoadSuccess(List<Grade_Names> grade_list);
    void onGradeLoadFailed(String message);
}
