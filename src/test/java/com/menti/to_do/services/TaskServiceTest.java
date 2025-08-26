package com.menti.to_do.services;

import com.menti.to_do.mappers.TaskMapper;
import com.menti.to_do.models.TaskRequest;
import com.menti.to_do.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @Test
    public void test() {
        when(taskRepository.findAll()).thenReturn(List.of());
        when(taskMapper.toListRequest(any())).thenReturn(List.of());
        List<TaskRequest> all = taskService.getAll();
        assertEquals(0, all.size());
    }

}
