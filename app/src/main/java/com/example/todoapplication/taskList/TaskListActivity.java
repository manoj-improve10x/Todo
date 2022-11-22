package com.example.todoapplication.taskList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.todoapplication.R;
import com.example.todoapplication.AddTaskActivity;
import com.example.todoapplication.TodoApi;
import com.example.todoapplication.TodoService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListActivity extends AppCompatActivity {

    public ArrayList<Task> taskList = new ArrayList<>();
    public RecyclerView taskListRv;
    public TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        getSupportActionBar().setTitle("Task List");
        //setupData();
        setupTaskRv();
        setupAddBtn();
        //fetchData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    public void fetchData() {
        TodoApi todoApi = new TodoApi();
        TodoService todoService = todoApi.createTodoService();
        Call<List<Task>> call = todoService.fetchTask();
        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                List<Task> tasks = response.body();
                taskAdapter.setData(tasks);
            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                Toast.makeText(TaskListActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });

    }

   /* public void setupData() {
        taskList = new ArrayList<>();

        Task getVegetables = new Task();
        getVegetables.taskName = "Get Vegetables";
        getVegetables.description = "for 1 week";
        taskList.add(getVegetables);

        Task readingNews = new Task();
        readingNews.taskName = "Reading News";
        readingNews.description = "explore politics, filmy and sports news";
        taskList.add(readingNews);

        Task prepareLunch = new Task();
        prepareLunch.taskName = "Prepare Lunch";
        prepareLunch.description = "Biryani and Raitha. yummyyyyy";
        taskList.add(prepareLunch);

        Task haveBreakfast = new Task();
        haveBreakfast.taskName = "Have Breakfast";
        haveBreakfast.description = "Healthy breakfast for a better morning";
        taskList.add(haveBreakfast);
    }*/

    public void setupTaskRv() {
        taskListRv = findViewById(R.id.task_list_rv);
        taskListRv.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter();
        taskAdapter.setData(taskList);
        taskListRv.setAdapter(taskAdapter);
    }

    public void setupAddBtn() {
        Button taskListAddBtn = findViewById(R.id.task_list_add_btn);
        taskListAddBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
            //finish();
        });
    }
}