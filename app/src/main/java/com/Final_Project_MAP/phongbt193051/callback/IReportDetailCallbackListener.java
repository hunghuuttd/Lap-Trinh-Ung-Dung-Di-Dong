package com.Final_Project_MAP.phongbt193051.callback;

import com.Final_Project_MAP.phongbt193051.model.Attendance_Students_List;

import java.util.List;

public interface IReportDetailCallbackListener {
    void onReportDetailLoadSuccess(List<Attendance_Students_List> attendance_students_lists);
    void onReportDetailLoadFailed(String message);
}
