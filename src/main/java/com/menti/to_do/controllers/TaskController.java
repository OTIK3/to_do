package com.menti.to_do.controllers;

import com.menti.to_do.enums.TaskStatusEnum;
import com.menti.to_do.models.TaskRequest;
import com.menti.to_do.services.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app/v1/to-do/")
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<List<TaskRequest>> all() {
        log.info("Get all Tasks started");
        List<TaskRequest> tasks = taskService.getAll();
        log.info("Get all Tasks ended with size {}", tasks.size());
        return ResponseEntity.ofNullable(tasks);
    }

    @GetMapping("/all/filter/{status}")
    public ResponseEntity<List<TaskRequest>> allFilterByStatus(@PathVariable TaskStatusEnum status) {
        log.info("Get filtered all Tasks by status: {} started", status);
        List<TaskRequest> filteredTasks = taskService.getAllFilterByStatus(status);
        log.info("Get filtered all Tasks by status: {} ended with size {}", status, filteredTasks.size());
        return ResponseEntity.ofNullable(filteredTasks);
    }

    @GetMapping("/all/sorted/time-limit")
    public ResponseEntity<List<TaskRequest>> allSortedByTimeLimit() {
        log.info("Get sorted all Tasks by timeLimit started");
        List<TaskRequest> sortedTasks = taskService.getAllSortedByTimeLimit();
        log.info("Get sorted all Tasks by timeLimit ended");
        return ResponseEntity.ofNullable(sortedTasks);
    }

    @GetMapping("/all/sorted/status")
    public ResponseEntity<List<TaskRequest>> allSortedByStatus() {
        log.info("Get sorted all Tasks by status started");
        List<TaskRequest> sortedTasks = taskService.getAllSortedByStatus();
        log.info("Get sorted all Tasks by status ended");
        return ResponseEntity.ofNullable(sortedTasks);
    }

    @PostMapping("/create")
    public ResponseEntity<UUID> create(@RequestBody TaskRequest taskRequest) {
        log.info("Create Task by {} started", taskRequest);
        UUID taskId = taskService.createByRequestTask(taskRequest);
        log.info("Create Task ended with id: {}", taskId);
        return ResponseEntity.ofNullable(taskId);
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<UUID> change(@RequestBody TaskRequest taskRequest, @PathVariable UUID id) {
        log.info("Change Task by {} started", taskRequest);
        UUID taskId = taskService.changeByRequestTask(taskRequest, id);
        log.info("Change Task ended with id: {}", taskId);
        return ResponseEntity.ofNullable(taskId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        log.info("Delete Task by id: {} started", id);
        taskService.deleteById(id);
        log.info("Delete Task by id: {} ended", id);
        return ResponseEntity.ok().build();
    }

}
