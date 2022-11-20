package com.example.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.todoapplication.R;
import com.example.todoapplication.taskList.TaskListActivity;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setTitle("Add Task");
        setupAddBtn();
    }

    public void setupAddBtn() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            TextView taskNameTxt = findViewById(R.id.task_text_txt);
            String task = taskNameTxt.getText().toString();
            TextView descriptionTextTxt = findViewById(R.id.description_text_txt);
            String description = descriptionTextTxt.getText().toString();
        });
    }
}