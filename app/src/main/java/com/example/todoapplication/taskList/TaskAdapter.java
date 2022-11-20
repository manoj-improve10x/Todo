package com.example.todoapplication.taskList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapplication.R;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    public ArrayList<Task> tasks;

    public void  setData(ArrayList<Task> taskArrayList) {
        tasks = taskArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        TaskViewHolder taskViewHolder = new TaskViewHolder(view);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.taskTxt.setText(task.taskName);
        holder.descriptionTxt.setText(task.description);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
