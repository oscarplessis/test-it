package com.example.testit.service;

import com.example.testit.adapter.mail.MailService;
import com.example.testit.model.Task;
import com.example.testit.repository.TaskRepository;
import com.example.testit.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.testit.model.User;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

public class UserServiceTest {

    TaskService taskService;
    TaskRepository taskRepository;
    MailService mailService;
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        taskRepository = Mockito.mock(TaskRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
        mailService = Mockito.mock(MailService.class);
        taskService = new TaskService(taskRepository, userRepository, mailService);
    }

    @Test
    public void testUserService() {
        Task task = new Task();
        task.setId(1L);

        //Mockito.when(taskService.findById(1L)).thenReturn(Optional.of(task));

        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(new User()));

        taskService.createTask("un titre " ,"une description", 0L, 2L);
        Mockito.verify(taskRepository).save(any());
    }
}
