package com.menti.to_do.models;

import com.menti.to_do.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    @Column(name = "time_limit")
    private LocalDate timeLimit;

    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    private TaskStatusEnum status = TaskStatusEnum.TODO;

}
