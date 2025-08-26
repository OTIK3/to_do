package com.menti.to_do.services;

import com.menti.to_do.enums.TaskStatusEnum;
import com.menti.to_do.exceptions.TaskNotFoundException;
import com.menti.to_do.mappers.TaskMapper;
import com.menti.to_do.models.TaskEntity;
import com.menti.to_do.models.TaskRequest;
import com.menti.to_do.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    //TODO в идеале сделать пагинацию
    public List<TaskRequest> getAll() {
        List<TaskEntity> tasks = taskRepository.findAll();
        return taskMapper.toListRequest(tasks);
    }

    //TODO в идеале сделать пагинацию
    public List<TaskRequest> getAllFilterByStatus(TaskStatusEnum status) {
        List<TaskEntity> filteredTasks = taskRepository.findAllFilterByStatus(status);
        return taskMapper.toListRequest(filteredTasks);
    }

    //TODO в идеале сделать пагинацию
    public List<TaskRequest> getAllSortedByTimeLimit() {
        List<TaskEntity> sortedTasks = taskRepository.findAllByOrderByTimeLimit();
        return taskMapper.toListRequest(sortedTasks);
    }

    //TODO в идеале сделать пагинацию
    public List<TaskRequest> getAllSortedByStatus() {
        List<TaskEntity> sortedTasks = taskRepository.findAllByOrderByStatus();
        return taskMapper.toListRequest(sortedTasks);
    }

    @Transactional
    public UUID createByRequestTask(TaskRequest taskRequest) {
        TaskEntity task = taskMapper.toEntity(taskRequest);
        TaskEntity savedTask = taskRepository.save(task);
        return savedTask.getId();
    }

    @Transactional
    public UUID changeByRequestTask(TaskRequest taskRequest, UUID id) {
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        TaskEntity changedTask = taskMapper.toEntity(task, taskRequest);
        TaskEntity savedTask = taskRepository.save(changedTask);
        return savedTask.getId();
    }

    @Transactional
    public void deleteById(UUID id) {
        taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        taskRepository.deleteById(id);
    }

}
