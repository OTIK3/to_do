package com.menti.to_do.mappers;

import com.menti.to_do.models.TaskEntity;
import com.menti.to_do.models.TaskRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    List<TaskRequest> toListRequest(List<TaskEntity> tasks);

    TaskRequest toRequest(TaskEntity entity);

    @Mapping(target = "id", ignore = true)
    TaskEntity toEntity(TaskRequest taskRequest);

    TaskEntity toEntity(@MappingTarget TaskEntity task, TaskRequest taskRequest);

}
