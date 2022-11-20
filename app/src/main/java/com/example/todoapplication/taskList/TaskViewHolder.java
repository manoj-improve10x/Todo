package com.example.todoapplication.taskList;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapplication.R;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    TextView taskTxt;
    TextView descriptionTxt;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        taskTxt = itemView.findViewById(R.id.task_txt);
        descriptionTxt = itemView.findViewById(R.id.description_txt);
    }
}
