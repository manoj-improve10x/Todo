package com.example.todoapplication.taskList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.todoapplication.R;
import com.example.todoapplication.AddTaskActivity;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    public ArrayList<Task> tasks;
    public RecyclerView taskListRv;
    public TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        getSupportActionBar().setTitle("Task List");
        setupData();
        setupTaskRv();
        setupAddBtn();
    }

    public void setupData() {
        tasks = new ArrayList<>();

        Task getVegetables = new Task();
        getVegetables.taskName = "Get Vegetables";
        getVegetables.description = "for 1 week";
        tasks.add(getVegetables);

        Task readingNews = new Task();
        readingNews.taskName = "Reading News";
        readingNews.description = "explore politics, filmy and sports news";
        tasks.add(readingNews);

        Task prepareLunch = new Task();
        prepareLunch.taskName = "Prepare Lunch";
        prepareLunch.description = "Biryani and Raitha. yummyyyyy";
        tasks.add(prepareLunch);

        Task haveBreakfast = new Task();
        haveBreakfast.taskName = "Have Breakfast";
        haveBreakfast.description = "Healthy breakfast for a better morning";
        tasks.add(haveBreakfast);
    }

    public void setupTaskRv() {
        taskListRv = findViewById(R.id.task_list_rv);
        taskListRv.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter();
        taskAdapter.setData(tasks);
        taskListRv.setAdapter(taskAdapter);
    }

    public void setupAddBtn() {
        Button taskListAddBtn = findViewById(R.id.task_list_add_btn);
        taskListAddBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
            finish();
        });
    }
}