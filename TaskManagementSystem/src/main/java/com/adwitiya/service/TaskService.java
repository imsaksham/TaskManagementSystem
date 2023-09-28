package com.adwitiya.service;
import java.util.List;

import com.adwitiya.model.Task;

public interface TaskService {
	List<Task> getAllTasks();
    Task getTaskById(Long taskId);
    Task getTasksByUserId(Long userId);
    Task createTask(Task task);
    String updateTask(Task task);
    void markTaskAsCompleted(Task task, Long taskId);
    void deleteTask(Long taskId);
}
