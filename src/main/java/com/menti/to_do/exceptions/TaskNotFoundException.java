package com.menti.to_do.exceptions;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {

    private final static String DEFAULT_MESSAGE = "Не найдена задача по идентификатору: %s";

    public TaskNotFoundException(UUID id) {
        super(DEFAULT_MESSAGE.formatted(id));
    }

}
