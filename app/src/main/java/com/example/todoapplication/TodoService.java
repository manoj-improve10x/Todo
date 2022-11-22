package com.example.todoapplication;

import com.example.todoapplication.taskList.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TodoService {

    @GET("ManojTodo")
    Call<List<Task>> fetchTask();

    @POST("ManojTodo")
    Call<Task> createTask(@Body Task task);
}
