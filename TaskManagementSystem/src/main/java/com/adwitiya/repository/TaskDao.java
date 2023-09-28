package com.adwitiya.repository;

import java.util.List;

import com.adwitiya.model.Task;

public interface TaskDao {

	public List<Task> getAllTasks();

    public Task getTaskById(Long taskId);

    public Task createTask(Task task);

    public void updateTask(Task task);

    public void markTaskAsCompleted(Task task, Long taskId);

    public void deleteTaskById(Long taskId);
}
