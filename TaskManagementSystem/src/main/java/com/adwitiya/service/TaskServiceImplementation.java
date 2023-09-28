package com.adwitiya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adwitiya.model.Task;
import com.adwitiya.repository.TaskDaoImplementation;

public class TaskServiceImplementation implements TaskService {

	@Autowired
	private TaskDaoImplementation taskDao;
	
	@Override
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskDao.getTaskById(taskId);
    }

    @Override
    public Task getTasksByUserId(Long taskId) {
        return taskDao.getTaskById(taskId);
    }

    @Override
    public Task createTask(Task task) {
        return taskDao.createTask(task);
    }

    @Override
    public String updateTask(Task task) {
    	task.setName(task.getName());
        task.setDescription(task.getDescription());
        task.setPriority(task.getPriority());
        task.setDueDate(task.getDueDate());
        task.setCompleted(task.isCompleted());

        taskDao.updateTask(task);
        
        return "Data has been updated successfully";
    }

    @Override
    public void markTaskAsCompleted(Task task,Long taskId) {
    	taskDao.markTaskAsCompleted(task, taskId);
    }

    @Override
    public void deleteTask(Long taskId) {
    	taskDao.deleteTaskById(taskId);
    }

}
