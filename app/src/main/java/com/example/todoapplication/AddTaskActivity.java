package com.example.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todoapplication.R;
import com.example.todoapplication.taskList.Task;
import com.example.todoapplication.taskList.TaskListActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setTitle("Add Task");
        setupAddBtn();

    }

    public void addTask(String name,String description) {
        Task task = new Task();
        task.taskName = name;
        task.description = description;

        TodoApi todoApi = new TodoApi();
        TodoService todoService = todoApi.createTodoService();
        Call<Task> call = todoService.createTask(task);
        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                Toast.makeText(AddTaskActivity.this, "successfully added the task", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(AddTaskActivity.this, "failed to add new task", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setupAddBtn() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            TextView taskNameTxt = findViewById(R.id.task_text_txt);
            String task = taskNameTxt.getText().toString();
            TextView descriptionTextTxt = findViewById(R.id.description_text_txt);
            String description = descriptionTextTxt.getText().toString();
            addTask(task, description);
        });
    }
}