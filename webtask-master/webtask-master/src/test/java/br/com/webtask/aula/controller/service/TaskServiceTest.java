/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webtask.aula.controller.service;

import br.com.webtask.aula.domain.model.Task;
import br.com.webtask.aula.domain.repo.TaskRepo;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author danig
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class TaskServiceTest {
    
    @InjectMocks
    private TaskService tasks;
    
    @MockBean
    private TaskRepo tasksRepo;
    
    public TaskServiceTest() {
    }
    
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Test1")
    public void testSomeMethod1() throws Exception {
        //Cenario
        Task t = new Task(1l,"abc", LocalDate.now().minusDays(2),null, null);
        Task t2 = new Task(1l,"abc", LocalDate.now().minusDays(2),LocalDate.now(), null);
        
        Mockito.when(tasksRepo.save(Mockito.any(Task.class))).thenReturn(t2);
        
        //Executar
        Task t1 = tasks.finalizar(t);
        
        //Verificar            
        Assertions.assertTrue(t1.isFinish());
    }
    
    @Test
    @DisplayName("Test2")
    public void testSomeMethod2(){
        //Cenario
        Task t = new Task(1l,"", LocalDate.now().minusDays(2),null, null);
        Task t2 = new Task(1l,"", LocalDate.now().minusDays(2),LocalDate.now(), null);
        
        Mockito.when(tasksRepo.save(Mockito.any(Task.class))).thenReturn(t2);
        
        //Executar
        Task t1;
        try {
            t1 = tasks.finalizar(t);
            Assertions.fail("deveria gerar Error");
        } catch (Exception ex) {
            //Verificar            
            Assertions.assertTrue(true);
        }       
        
    }
    
}
