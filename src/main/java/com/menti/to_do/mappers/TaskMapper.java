package com.menti.to_do.mappers;

import com.menti.to_do.models.TaskEntity;
import com.menti.to_do.models.TaskRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    List<TaskRequest> toListRequest(List<TaskEntity> tasks);

    TaskEntity toEntity(TaskRequest taskRequest);

    TaskEntity toEntity(TaskEntity task, TaskRequest taskRequest);

}
