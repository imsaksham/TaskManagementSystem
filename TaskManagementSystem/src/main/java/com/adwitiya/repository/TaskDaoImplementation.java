package com.adwitiya.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.adwitiya.model.Task;

@Repository
public class TaskDaoImplementation implements TaskDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Task> getAllTasks() {
		String query = "select * from task";
		
		return jdbcTemplate.query(query, new TaskRowMapper());
	}

	@Override
	public Task getTaskById(Long taskId) {
		String query = "select * from task where id = ?";
		
		return jdbcTemplate.queryForObject(query, new Object[] {taskId}, new TaskRowMapper());
	}

	@Override
	public Task createTask(Task task) {
		String query = "insert into tasks (name, description, priority, due_date, is_completed) values (?,?,?,?,?)";
		jdbcTemplate.update(query, task.getName(), task.getDescription(), task.getPriority().toString(), task.getDueDate(), task.isCompleted());
		
		return task;
	}

	@Override
	public void updateTask(Task task) {
		String query = "update tasks set description = ?, priority = ?, due_date = ? WHERE id = ?";
		jdbcTemplate.update(query, task.getDescription(), task.getPriority().toString(), task.getDueDate(), task.getId());
	}

	@Override
	public void markTaskAsCompleted(Task task, Long taskId) {
		String query = "update tasks set is_completed = ? where id = ?";
		
		jdbcTemplate.update(query, task.isCompleted(), taskId);
	}

	@Override
	public void deleteTaskById(Long taskId) {
		String query = "delete from task where id = ?";
		
		jdbcTemplate.update(query, taskId);
	}

}
