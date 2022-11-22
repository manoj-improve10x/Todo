package com.example.todoapplication.taskList;

import com.google.gson.annotations.SerializedName;

public class Task {

    @SerializedName("_id")
    public String id;

    @SerializedName("task")
    public String taskName;
    public String description;
}
