package com.tasks.routes;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.models.Tasks;
import com.tasks.models.Users;
import com.tasks.controller.TasksController;
import com.tasks.controller.UsersController;

@CrossOrigin
@RequestMapping("tasks")
@RestController
public class TasksRoute {

	@Autowired
	private TasksController TasksController;
	private UsersController UsersController;
	
	@PostMapping("/save")
	public ResponseEntity<Boolean> saveTasks(@RequestBody Tasks tasks) {
		TasksController.save(tasks);
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	@GetMapping("/listar")
	public List<Tasks> getTasks() {
		return TasksController.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	public Optional<Tasks> getOne(@PathVariable Integer id) {
		return TasksController.findById(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteTask(@RequestBody Tasks tasks) {
		TasksController.deleteById(tasks.getIdtask());
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Boolean> updateTask(@RequestBody Tasks tasks, @PathVariable Integer id) {
		Optional<Tasks> task = TasksController.findById(id);
		Tasks taskUpdate = task.get();
		taskUpdate.setTitle(tasks.getTitle());
		taskUpdate.setDescription(tasks.getDescription());
		taskUpdate.setState(tasks.getState());
		taskUpdate.setDate_execution(tasks.getDate_execution());
		taskUpdate.setTime_execution(tasks.getTime_execution());
		//taskUpdate.setIduserone(tasks.getIduserone());
		//taskUpdate.setIdusertwo(tasks.getIdusertwo());
		TasksController.save(taskUpdate);
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	@PostMapping("/getDataByUser/")
	public List<Tasks> getDataByUser(@RequestBody Users user) {
		return TasksController.findByUserAssigned(user);
	}
}
