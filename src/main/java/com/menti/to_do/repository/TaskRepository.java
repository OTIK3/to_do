package com.menti.to_do.repository;

import com.menti.to_do.enums.TaskStatusEnum;
import com.menti.to_do.models.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {

    List<TaskEntity> findAllFilterByStatus(TaskStatusEnum status);

    List<TaskEntity> findAllByOrderByTimeLimit();

    List<TaskEntity> findAllByOrderByStatus();

}
