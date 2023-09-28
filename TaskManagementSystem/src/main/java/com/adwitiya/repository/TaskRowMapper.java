package com.adwitiya.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.adwitiya.model.Priority;
import com.adwitiya.model.Task;

public class TaskRowMapper implements RowMapper<Task> {

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		Task task = new Task();
		
		task.setId(rs.getLong("id"));
		task.setName(rs.getString("name"));
        task.setDescription(rs.getString("description"));
		task.setPriority(Priority.valueOf(rs.getString("priority")));
		
		Timestamp timestamp = rs.getTimestamp("due_date");
		if (timestamp != null) {
			task.setDueDate(timestamp.toLocalDateTime());
		}
		
        task.setCompleted(rs.getBoolean("is_completed"));
        
        return task;
	}

	
}
