package com.tasks.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tasks.models.Tasks;
import com.tasks.models.Users;

public interface TasksController extends JpaRepository<Tasks, Integer> {
	//@Query("select x from Tasks where x.idtask = :var_parm")
	List<Tasks> findByUserAssigned(Users userAssigned);
}
