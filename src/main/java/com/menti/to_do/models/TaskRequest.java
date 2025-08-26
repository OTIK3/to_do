package com.menti.to_do.models;

import com.menti.to_do.enums.TaskStatusEnum;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaskRequest {

    private String name;
    private String description;
    private LocalDate timeLimit;
    private TaskStatusEnum status;

    public TaskRequest(String name, String description, LocalDate timeLimit) {
        this.name = name;
        this.description = description;
        this.timeLimit = timeLimit;
    }

}
